package volume;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import org.example.Console;

import java.util.List;

public class VolumeService {
    public static void coletarDadosDisco(Console console) {
        Looca looca = new Looca();
        DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();
        List<Volume> volume = grupoDeDiscos.getVolumes();
        List<Disco> discos = grupoDeDiscos.getDiscos();

        for (int i = 0; i < volume.size(); i++) {
            double totalMemoria = volume.get(i).getTotal() / Math.pow(1024,3);
            double discoDisponivel = volume.get(i).getDisponivel() / Math.pow(1024,3);
            double totalDisco = discos.get(i).getTamanho() / Math.pow(1024,3);

            double usoPorcentagemDisco = ((((totalMemoria - discoDisponivel) * 100) / totalMemoria));

            volume.Volume volumeMet = new volume.Volume();
            volumeMet.setEspacoTotal(totalMemoria);
            volumeMet.setEspacoDisponivel(discoDisponivel);
            volumeMet.setTotalDisco(totalDisco);

            volumeMet.setDiscoEmUso((double) Math.round(usoPorcentagemDisco));
//            new VolumeDAO().cadastrarDados(volumeMet, console);
            new VolumeDAOVm().cadastrarDados(volumeMet, console);

        }
    }

}

