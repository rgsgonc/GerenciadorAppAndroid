package br.com.fean.gerenciadorfinanceiro;

import java.io.Serializable;

/**
 * Created by rafael on 16/11/17.
 */

public class Categoria implements Serializable {
        private int id;
        private String nomeCategoria;
        private Double orcamento;

        public Categoria(){}

        //public Categoria(int id, String nomeCategoria, Double orcamento) {
          //  super();
            //this.id = id;
            //this.nomeCategoria = nomeCategoria;
            //this.orcamento = orcamento;
        //}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNomeCategoria() {
            return nomeCategoria;
        }

        public void setNomeCategoria(String nomeCategoria) {
            this.nomeCategoria = nomeCategoria;
        }

        public Double getOrcamento() {
            return orcamento;
        }

        public void setOrcamento(Double orcamento) {
            this.orcamento = orcamento;
        }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.id + " - ");
        stringBuilder.append(this.nomeCategoria + " ");

        if(this.orcamento != null) {
            stringBuilder.append("R$"+this.getOrcamento());
        }

        return stringBuilder.toString();
    }
}