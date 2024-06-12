package Slack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import BancoDeDados.BancoLooca;

public class SlackEnvio {

    public void consultarBancoEnviar() {

        String idCanalSlack = "C06TKK2SSK0";

        try {
            // Obter a conexão com o banco de dados usando getbancoLooca2
            Connection conect = BancoLooca.getbancoLooca();

            // Consulta para verificar novos alertas onde enviado é false
            String query = "SELECT * FROM parametrosDeAlerta WHERE enviado = 0";

            try (PreparedStatement stmt = conect.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Pegar os dados do alerta
                    int idEmpresa = rs.getInt("idEmpresa");
                    String ramWarning = rs.getString("ramWarning");
                    String ramDanger = rs.getString("ramDanger");
                    String processadorWarning = rs.getString("processadorWarning");
                    String processadorDanger = rs.getString("processadorDanger");
                    String internetWarning = rs.getString("internetWarning");
                    String internetDanger = rs.getString("internetDanger");
                    String discoWarning = rs.getString("discoWarning");
                    String discoDanger = rs.getString("discoDanger");

                    // Monta a mensagem do Slack ignorando campos vazios
                    String mensagem = montarMensagem(idEmpresa, ramWarning, ramDanger, processadorWarning, processadorDanger, internetWarning, internetDanger, discoWarning, discoDanger);

                    // Envia a mensagem para o Slack
                    PublishingMessage.publishMessage(idCanalSlack, mensagem);

                    // Atualiza o campo enviado para true
                    marcarComoEnviado(conect, idEmpresa);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void marcarComoEnviado(Connection connection, int idEmpresa) throws SQLException {
        String updateSQL = "UPDATE parametrosDeAlerta SET enviado = true WHERE idEmpresa = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setInt(1, idEmpresa);
            pstmt.executeUpdate();
        }
    }

    private static String montarMensagem(int idEmpresa, String... parametros) {
        StringBuilder mensagem = new StringBuilder(String.format("Alerta Empresa ID: %d\n", idEmpresa));

        String[] labels = {"RAM Warning: ", "RAM Danger: ", "Processador Warning: ", "Processador Danger: ", "Internet Warning: ", "Internet Danger: ", "Disco Warning: ", "Disco Danger: "};

        for (int i = 0; i < parametros.length; i++) {
            if (parametros[i] != null && !parametros[i].isEmpty()) {
                mensagem.append(labels[i]).append(parametros[i]).append("\n");
            }
        }

        return mensagem.toString().trim();  // Remove o último caractere de nova linha
    }
}
