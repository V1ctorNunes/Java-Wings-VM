//package ram;
//import BancoDeDados.BancoLooca;
//import org.example.Console;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class RamDAO {
//
//    private static final Logger log = LoggerFactory.getLogger(RamDAO.class);
//
//    public void cadastrarDados(Ram metodoRam, Console console) {
//
//        String sql = "UPDATE ComputadorESpec set ramTotal = ? WHERE idComputador = ?";
//        String sql2 = "UPDATE Monitoramento SET ramUso = ? WHERE idMonitoramento = ?";
//
//
//        PreparedStatement ps = null;
//        PreparedStatement ps2 = null;
//
//        try {
//            ps = BancoLooca.getbancoLooca2().prepareStatement(sql);
//            ps.setDouble(1, metodoRam.getMemoriaTotal());
//            ps.setDouble(2, console.getIdComputadorVm());
//            ps.executeUpdate();
//
//            ps2 = BancoLooca.getbancoLooca2().prepareStatement(sql2);
//            ps2.setDouble(1, metodoRam.getRamEmUso());
//            ps2.setDouble(2, console.getIdMonitoramento() + 1);
//            ps2.executeUpdate();
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
