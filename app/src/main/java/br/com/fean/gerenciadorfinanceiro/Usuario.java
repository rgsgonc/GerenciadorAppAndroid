package br.com.fean.gerenciadorfinanceiro;

import java.io.Serializable;

/**
 * Created by rafael on 16/11/17.
 */

public class Usuario implements Serializable{
    private int id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(){}


    public Usuario(int id, String nome, String endereco, String email, String telefone, String senha) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.email;
    }



}
