//package Log;
//import BancoDeDados.BancoLooca;
//import com.github.britooo.looca.api.group.sistema.Sistema;
//import org.example.Console;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class LogMonitoramento {
//
//    public static void Logs(Console console) throws IOException {
//        Sistema sistema = new Sistema();
//        String SO = sistema.getSistemaOperacional();
//        Integer arq = sistema.getArquitetura();
//        console.setSO(SO);
//        console.setArq(arq);
//        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//        System.out.println(console.getEntrou());
//
//        if (console.getEntrou()) {
//            LocalDateTime localDateTime = LocalDateTime.now();
//            generateLog("{" + formatadorDeData.format(localDateTime) + "} " + "[LOGIN] " + "[Sistema Operacional: " + console.getSO() + "] " + "[Arquitetura: " + console.getArq() + "] " +  "Usuário " + console.getNome() + " logado " + "\n");
//        }
//        else {
//            LocalDateTime localDateTime = LocalDateTime.now();
//            generateLog("{" + formatadorDeData.format(localDateTime) + "} " + "[ERROR] " + "[Sistema Operacional: " + console.getSO() + "] " + "[Arquitetura: " + console.getArq() + "] " +  "Houve uma tentativa de LOGIN " + "\n");
//        }
//    }
//
//    public static void LogOpcao(Console console,  Boolean criarLog) throws IOException {
//        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//    if(criarLog) {
//            if(console.getOpcao() == 1) {
//                LocalDateTime localDateTime1 = LocalDateTime.now();
//                generateLog("{" + formatadorDeData.format(localDateTime1) + "} " +"[INFO] " + " Coleta de dados " + "\n");
//            }
//
//            if(console.getOpcao() == 2) {
//                LocalDateTime localDate = LocalDateTime.now();
//                generateLog("{" + formatadorDeData.format(localDate) + "} " +"[INFO] " + " Encerrar processos foi iniciado! " + "\n");
//            }
//
//            if(console.getOpcao() == 3) {
//                LocalDateTime localDate2 = LocalDateTime.now();
//                generateLog("{" + formatadorDeData.format(localDate2) + "} " + "[LOGOUT] " + " Aplicação encerrada. " + "\n");
//            }
//        }
//    }
//    public static void LogEscolha(Console console) throws IOException {
//        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        List<Double> uso = new ArrayList<>();
//        List<Double> ram = new ArrayList<>();
//        List<Double> disco = new ArrayList<>();
//            if (console.getEscolha() == 1) {
//
//                String sql = "SELECT processadorUso FROM Monitoramento ORDER BY idMonitoramento desc limit 1";
//
//                try(PreparedStatement ps = BancoLooca.getbancoLooca().prepareStatement(sql)) {
//                    try (ResultSet rs = ps.executeQuery()) {
//                        while (rs.next()) {
//                            Double usoProc = (Double) rs.getObject("processadorUso");
//                            if (usoProc != null) {
//                                uso.add(usoProc);
//                            }
//                            LocalDateTime localDateTime1 = LocalDateTime.now();
//                            generateLog("{" + formatadorDeData.format(localDateTime1) + "} " +"[INFO] " + "Coleta "+ console.getContagem() + "\n");
//                            double mediaUso = uso.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
//                            String mensageLog;
//                            if (mediaUso >= 90 && mediaUso <= 100) {
//                                LocalDateTime localDate1 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate1) + "} " + "[WARNING] " + " Uso do Processador está alterado! " + "\n";
//                            } else if (mediaUso >= 50 && mediaUso < 90) {
//                                LocalDateTime localDate2 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate2) + "} " + "[ALERT] " + " Uso do Processador está ná média!! " + "\n";
//                            } else {
//                                LocalDateTime localDate3 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate3) + "} " + "[GOOD] " + " Uso do Processador está bom! " + "\n";
//                            }
//
//                            generateLog(mensageLog);
//                        }
//                    }
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                String sql2 = "SELECT ramUso FROM Monitoramento ORDER BY idMonitoramento desc limit 1";
//                try(PreparedStatement ps2 = BancoLooca.getbancoLooca().prepareStatement(sql2)) {
//                    try (ResultSet rs2 = ps2.executeQuery()) {
//                        while (rs2.next()) {
//                            Double ramUso = rs2.getObject("ramUso") instanceof Double ? (Double) rs2.getObject("ramUso") : null;
//                            if (ramUso != null) {
//                                ram.add(ramUso);
//                            }
//                            double mediaRam = ram.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
//                            String mensageLog;
//                            if (mediaRam >= 90 && mediaRam <= 100) {
//                                LocalDateTime localDate1 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate1) + "} " + "[WARNING] " + " Uso da memória RAM está alterado! " + "\n";
//                            } else if (mediaRam >= 50 && mediaRam <= 90) {
//                                LocalDateTime localDate2 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate2) + "} " + "[ALERT] " + " Uso da memória RAM está ná média!! " + "\n";
//                            } else {
//                                LocalDateTime localDate3 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate3) + "} " + "[GOOD] " + " Uso da memória RAM está bom! " + "\n";
//                            }
//
//                            generateLog(mensageLog);
//                        }
//                    }
//                } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                String sql4 = "SELECT discoUso FROM Monitoramento ORDER BY idMonitoramento desc limit 1";
//                try(PreparedStatement ps4 = BancoLooca.getbancoLooca().prepareStatement(sql4)) {
//                    try(ResultSet rs4 = ps4.executeQuery()) {
//                        while (rs4.next()) {
//                            Double discoUso = rs4.getObject("discoUso") instanceof Double ? (Double) rs4.getObject("discoUso") : null;
//                            if(discoUso != null) {
//                                disco.add(discoUso);
//                            }
//                            double mediaDisco = uso.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
//                            String mensageLog;
//                            if(mediaDisco >= 90 && mediaDisco <= 100) {
//                                LocalDateTime localDate1 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate1) + " }" + "[WARNING] " + " Uso do Disco está alterado! " + "\n";
//                            } else if (mediaDisco >= 50 && mediaDisco <= 90) {
//                                LocalDateTime localDate2 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate2) + "} " + "[ALERT] " + " Uso do Disco está ná média!! " + "\n";
//                            } else {
//                                LocalDateTime localDate3 = LocalDateTime.now();
//                                mensageLog = "{" + formatadorDeData.format(localDate3) + "} " + "[GOOD] " + " Uso do Disco está bom! " + "\n";
//                            }
//
//                            generateLog(mensageLog);
//                        }
//                    }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//
//    public static void generateLog(String message) throws IOException {
//        Date data = new Date();
//        SimpleDateFormat formatadorDeData = new SimpleDateFormat("yyyyMMdd");
//
//        Date hora = new Date();
//        SimpleDateFormat formatadorDeHora = new SimpleDateFormat("HHM");
//
//        Path path = Paths.get("C:\\logs");
//
//        if (!Files.exists(path)) {
//            Files.createDirectories(path);
//        }
//
//        File log = new File("C:\\logs\\logs-" + formatadorDeData.format(data) + "-" + formatadorDeHora.format(hora) +".txt");
//
//        if(!log.exists()){
//            log.createNewFile();
//        }
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(log, true))) {
//            bw.write(message);
//        }
//    }
//}
//
