package br.com.fean.gerenciadorfinanceiro;

/**
 * Created by rafael on 17/11/17.
 */

public class Login {
    private String usuario;
    private String senha;

    public Login(String usuario, String senha) {
        super();
        this.usuario = usuario;
        this.senha = senha;
    }

    public Login(){}
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


}
