package volume;

import Heranca.Componentes;

public class Volume extends Componentes {

    private long totalDisco;
    private long espacoDisponivel;
    private long espacoTotal;
    private Double discoEmUso;

    public Volume(String nome, String descricao, long totalDisco, long espacoDisponivel, long espacoTotal, Double discoEmUso) {
        super(nome, descricao);
        this.totalDisco = totalDisco;
        this.espacoDisponivel = espacoDisponivel;
        this.espacoTotal = espacoTotal;
        this.discoEmUso = discoEmUso;
    }

    public Volume(long totalDisco, long espacoDisponivel, long espacoTotal, Double discoEmUso) {
        this.totalDisco = totalDisco;
        this.espacoDisponivel = espacoDisponivel;
        this.espacoTotal = espacoTotal;
        this.discoEmUso = discoEmUso;
    }

    public Volume() {}

    public String getTotalDisco() {
        return String.valueOf(totalDisco);
    }

    public void setTotalDisco(double totalDisco) {
        this.totalDisco = (long) totalDisco;
    }

    public String getEspacoDisponivel() {
        return String.valueOf(espacoDisponivel);
    }

    public void setEspacoDisponivel(double espacoDisponivel) {
        this.espacoDisponivel = (long) espacoDisponivel;
    }

    public String getEspacoTotal() {
        return String.valueOf(espacoTotal);
    }

    public void setEspacoTotal(double espacoTotal) {
        this.espacoTotal = (long) espacoTotal;
    }

    public String getDiscoEmUso() {
        return String.valueOf(discoEmUso);
    }

    public void setDiscoEmUso(Double discoEmUso) {
        this.discoEmUso = discoEmUso;
    }
}
