//package rede;
//import BancoDeDados.BancoLooca;
//import org.example.Console;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class RedeDAO {
//
//    public void cadastrarDados(Rede rede, Console console) {
//
//        String sql = "UPDATE Monitoramento SET bytesEnviados = ? WHERE idMonitoramento = ?";
//
//        try (PreparedStatement ps = BancoLooca.getbancoLooca2().prepareStatement(sql)) {
//            ps.setObject(1, rede.getBytesEnviados());
//            ps.setInt(2, console.getIdMonitoramento() + 1);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Erro ao inserir dados na tabela Monitoramento", e);
//        }
//    }
//}
