package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Console {

// LOGIN
    private String user;
    private String password;
    private Boolean entrou = false;

// IDSa
    private String nome;
    private Integer idUser = 0;
    private Integer idEmpresa = 0;
    private Integer idComputador = 0;
    private Integer idMonitoramento = 0;
    private Integer idComputadorVm = 0;
    private Integer idMonitoramentoVm = 0;

    public Integer getIdMonitoramentoVm() {
        return idMonitoramentoVm;
    }

    public void setIdMonitoramentoVm(Integer idMonitoramentoVm) {
        this.idMonitoramentoVm = idMonitoramentoVm;
    }

    public Integer getIdComputadorVm() {
        return idComputadorVm;
    }

    public void setIdComputadorVm(Integer idComputadorVm) {
        this.idComputadorVm = idComputadorVm;
    }

    private LocalDateTime tempo;

    public Console() {
        this.tempo = LocalDateTime.now();
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEntrou() {
        return entrou;
    }

    public void setEntrou(Boolean entrou) {
        this.entrou = entrou;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(Integer idComputador) {
        this.idComputador = idComputador;
    }

    public Integer getIdMonitoramento() {
        return idMonitoramento;
    }

    public void setIdMonitoramento(Integer idMonitoramento) {
        this.idMonitoramento = idMonitoramento;
    }


    // LOGS
    private Integer escolha = 0;
    private Integer opcao = 0;
    private String SO;
    private Integer arq = 0;
    private Integer contagem = 1;

    public void setEscolha(Integer escolha) {
        this.escolha = escolha;
    }

    public Integer getEscolha() {
        return escolha;
    }

    public Integer getOpcao() {
        return opcao;
    }

    public void setOpcao(Integer opcao) {
        this.opcao = opcao;
    }

    public String getSO() {
        return SO;
    }

    public void setSO(String SO) {
        this.SO = SO;
    }

    public Integer getArq() {
        return arq;
    }

    public void setArq(Integer arq) {
        this.arq = arq;
    }

    public Integer getContagem() {
        return contagem;
    }

    public void setContagem(Integer contagem) {
        this.contagem = contagem;
    }
}
