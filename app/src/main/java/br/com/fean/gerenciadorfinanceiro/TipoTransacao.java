package br.com.fean.gerenciadorfinanceiro;

/**
 * Created by rafael on 24/11/17.
 */

public enum TipoTransacao {

    DESPESA, RECEITA;

    private String nomeTransacao;

    TipoTransacao() {

    }

    public String getNomeTransacao() {
        return nomeTransacao;
    }

    public void setNomeTransacao(String nomeTransacao) {
        this.nomeTransacao = nomeTransacao;
    }

}
