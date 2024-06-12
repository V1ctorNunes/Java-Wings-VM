package processador;

import Heranca.Componentes;

import java.time.LocalDateTime;

public class ProcessadorMetodo extends Componentes {

    private String modelo;
    private Integer nucleosFisicos;
    private Integer nucleosLogicos;
    private long frequencia;
    private Double uso;

    public ProcessadorMetodo(String nome, String descricao, String modelo, Integer nucleosFisicos, Integer nucleosLogicos, long frequencia, Double uso) {
        super(nome, descricao);
        this.modelo = modelo;
        this.nucleosFisicos = nucleosFisicos;
        this.nucleosLogicos = nucleosLogicos;
        this.frequencia = frequencia;
        this.uso = uso;
    }

    public ProcessadorMetodo(String modelo, Integer nucleosFisicos, Integer nucleosLogicos, long frequencia, Double uso) {
        this.modelo = modelo;
        this.nucleosFisicos = nucleosFisicos;
        this.nucleosLogicos = nucleosLogicos;
        this.frequencia = frequencia;
        this.uso = uso;
    }

    public ProcessadorMetodo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNucleosFisicos() {
        return String.valueOf(nucleosFisicos);
    }

    public void setNucleosFisicos(Integer nucleosFisicos) {
        this.nucleosFisicos = nucleosFisicos;
    }

    public String getNucleosLogicos() {
        return String.valueOf(nucleosLogicos);
    }

    public void setNuclSeosLogicos(Integer nucleosLogicos) {
        this.nucleosLogicos = nucleosLogicos;
    }

    public String getFrequencia() {
        return String.valueOf(frequencia);
    }

    public void setFrequencia(long frequencia) {
        this.frequencia = frequencia;
    }

    public String getUso() {
        return String.valueOf(uso);
    }

    public void setUso(Double uso) {
        this.uso = uso;
    }

}
