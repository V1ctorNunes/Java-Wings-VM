package ram;
import BancoDeDados.BancoLooca;
import org.example.Console;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RamDAOVm {

    public void cadastrarDados(Ram metodoRam, Console console) {

        String sql = "UPDATE ComputadorESpec set ramTotal = ? WHERE idComputador = ?";
        String sql2 = "UPDATE Monitoramento SET ramUso = ? WHERE idMonitoramento = ?";


        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {
            ps = BancoLooca.getbancoLooca().prepareStatement(sql);
            ps.setDouble(1, metodoRam.getMemoriaTotal());
            ps.setInt(2, console.getIdComputadorVm());
            ps.executeUpdate();

            ps2 = BancoLooca.getbancoLooca().prepareStatement(sql2);
            ps2.setDouble(1, metodoRam.getRamEmUso());
            ps2.setInt(2, console.getIdMonitoramentoVm() + 1);
            ps2.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
