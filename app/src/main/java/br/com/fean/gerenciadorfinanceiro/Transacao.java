package br.com.fean.gerenciadorfinanceiro;

import java.util.Date;

/**
 * Created by rafael on 24/11/17.
 */


public class Transacao {
    private int id;
    private Date data;
    private String descricao;
    private String valor;
    private TipoTransacao tipoTransacao;

    public Transacao(int id, Date data, String descricao, String valor, TipoTransacao tipoTransacao) {
        super();
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
    }

    public Transacao(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

}

