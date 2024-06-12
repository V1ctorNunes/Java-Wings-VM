package ram;

import Heranca.Componentes;

public class Ram extends Componentes {

    private double disponivel;
    private double memoriaTotal;
    private double memoriaUtilizada;
    private double ramEmUso;

    public Ram(String nome, String descricao, double disponivel, double memoriaTotal, double memoriaUtilizada, double ramEmUso) {
        super(nome, descricao);
        this.disponivel = disponivel;
        this.memoriaTotal = memoriaTotal;
        this.memoriaUtilizada = memoriaUtilizada;
        this.ramEmUso = ramEmUso;
    }

    public Ram(double disponivel, double memoriaTotal, double memoriaUtilizada, double ramEmUso) {
        this.disponivel = disponivel;
        this.memoriaTotal = memoriaTotal;
        this.memoriaUtilizada = memoriaUtilizada;
        this.ramEmUso = ramEmUso;
    }

    public Ram() {
    }

    public double getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(double disponivel) {
        this.disponivel = disponivel;
    }

    public double getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(double memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public double getMemoriaUtilizada() {
        return memoriaUtilizada;
    }

    public void setMemoriaUtilizada(double memoriaUtilizada) {
        this.memoriaUtilizada = memoriaUtilizada;
    }

    public double getRamEmUso() {
        return ramEmUso;
    }

    public void setRamEmUso(double ramEmUso) {
        this.ramEmUso = ramEmUso;
    }
}
