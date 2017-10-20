package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void realizarLogin(View view){
        Intent realizarLogin = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(realizarLogin);
    }

    public void addNovoUsuario(View view){
        Intent addNovoUsuario = new Intent(SignUpActivity.this,TelaInicialActivity.class);
        startActivity(addNovoUsuario);
    }
}
