package rede;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.rede.RedeInterface;
import org.example.Console;

import java.util.List;

public class RedeService {
    public static void coletaRede(Console console) {
        Looca looca = new Looca();

        List<RedeInterface> redeInterfaces = looca.getRede().getGrupoDeInterfaces().getInterfaces();

        for (RedeInterface redeInterface : redeInterfaces) {
            long bytesEnviados = redeInterface.getBytesEnviados();

            Rede rede = new Rede();
            Console console1 = new Console();
            if (bytesEnviados != 0) {
                rede.setBytesEnviados(bytesEnviados);
//                new RedeDAO().cadastrarDados(rede, console);
                new RedeDAOVm().cadastrarDados(rede, console);
            }
        }
    }
}
