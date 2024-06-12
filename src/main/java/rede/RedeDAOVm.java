package rede;
import BancoDeDados.BancoLooca;
import org.example.Console;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RedeDAOVm {

    public void cadastrarDados(Rede rede, Console console) {

        String sql = "UPDATE Monitoramento SET bytesEnviados = ? WHERE idMonitoramento = ?";

        try (PreparedStatement ps = BancoLooca.getbancoLooca().prepareStatement(sql)) {
            ps.setObject(1, rede.getBytesEnviados());
            ps.setInt(2, console.getIdMonitoramentoVm() + 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados na tabela Monitoramento", e);
        }
    }
}
