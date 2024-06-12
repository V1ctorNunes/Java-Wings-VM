package ram;
import com.github.britooo.looca.api.core.Looca;
import org.example.Console;

public class RamService {
    public static void coletaDeRam(Console console) {
        Looca looca = new Looca();

        double usoEmPorcentagemRam = 0.0;
        double totalRam = looca.getMemoria().getTotal() / Math.pow(1024,3);
        double diponivelRam = looca.getMemoria().getDisponivel() / Math.pow(1024,3);


        usoEmPorcentagemRam = (((totalRam - diponivelRam) * 100) / totalRam);
        Ram metodoRam = new Ram();
        metodoRam.setMemoriaTotal(totalRam);
        metodoRam.setRamEmUso(Math.round(usoEmPorcentagemRam));
//        new RamDAO().cadastrarDados(metodoRam, console);
        new RamDAOVm().cadastrarDados(metodoRam, console);


    }
}
