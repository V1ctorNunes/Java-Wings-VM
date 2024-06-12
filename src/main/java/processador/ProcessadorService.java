package processador;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processador.Processador;
import org.example.Console;

import java.sql.SQLException;
import java.text.DecimalFormat;

public class ProcessadorService {
    public static void coletaDeProcessador(Console console) throws SQLException {
        Looca looca = new Looca();

        Processador processador = looca.getProcessador();

        String modeloProcessador = processador.getNome();
        Integer nucleosFisico = processador.getNumeroCpusFisicas();
        Integer nucleosLogicos = processador.getNumeroCpusLogicas();
        Long frequencia = processador.getFrequencia();
        Double uso = processador.getUso();

        DecimalFormat dfTotal = new DecimalFormat("#.##");
        String processadorEmUso_Formatado = dfTotal.format(uso);
        processadorEmUso_Formatado = processadorEmUso_Formatado.replace("," , ".");
        Double usoDoProcessador = Double.parseDouble(processadorEmUso_Formatado);


        ProcessadorMetodo processador1 = new ProcessadorMetodo();

        processador1.setModelo(modeloProcessador);
        processador1.setNucleosFisicos(nucleosFisico);
        processador1.setNuclSeosLogicos(nucleosLogicos);
        processador1.setFrequencia(frequencia);
        processador1.setUso(usoDoProcessador);
//        new ProcessadorDAO().cadastrarDados(processador1, console);
        new ProcessadorDAOVm().cadastrarDados(processador1, console);

    }
}
