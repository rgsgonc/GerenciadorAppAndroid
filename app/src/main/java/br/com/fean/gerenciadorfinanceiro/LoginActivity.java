package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void realizarLogin(View view){
        Intent realizarLogin = new Intent(LoginActivity.this,TelaInicialActivity.class);
        startActivity(realizarLogin);
    }

    public void addNovoUsuario(View view){
        Intent addNovoUsuario = new Intent(LoginActivity.this,CadastrarUsuarioActivity.class);
        startActivity(addNovoUsuario);
    }


}
