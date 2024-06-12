package Heranca;

public class Componentes {
    private String nome;
    private String descricao;

    public Componentes(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Componentes() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
