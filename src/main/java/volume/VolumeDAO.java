//package volume;
//import BancoDeDados.BancoLooca;
//import org.example.Console;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class VolumeDAO {
//
//    public void cadastrarDados(Volume volume, Console console) {
//
//        String sql1 = "UPDATE ComputadorESpec SET discoTotal = ? WHERE idComputador = ?";
//        String sql2 = "UPDATE Monitoramento SET discoUso = ? WHERE idMonitoramento = ?";
//
//        PreparedStatement ps1 = null;
//        PreparedStatement ps2 = null;
//
//        try {
//            ps1 = BancoLooca.getbancoLooca2().prepareStatement(sql1);
//            ps1.setString(1, volume.getTotalDisco());
//            ps1.setInt(2, console.getIdComputadorVm());
//            ps1.executeUpdate();
//            ps1.close();
//
//            ps2 = BancoLooca.getbancoLooca2().prepareStatement(sql2);
//            ps2.setString(1, volume.getDiscoEmUso());
//            ps2.setInt(2, console.getIdMonitoramento() + 1);
//            ps2.executeUpdate();
//            ps2.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//}
//
