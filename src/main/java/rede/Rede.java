package rede;

import Heranca.Componentes;

public class Rede extends Componentes {
    private long bytesEnviados;

    public Rede(String nome, String descricao, long bytesEnviados) {
        super(nome, descricao);
        this.bytesEnviados = bytesEnviados;
    }

    public Rede(long bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
    }

    public Rede() {

    }

    public String getBytesEnviados() {
        return String.valueOf(bytesEnviados);
    }

    public void setBytesEnviados(long bytesEnviados) {
        this.bytesEnviados = bytesEnviados;
    }
}
