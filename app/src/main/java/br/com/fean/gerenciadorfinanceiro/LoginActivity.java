package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        email = (EditText) findViewById(R.id.input_email);
        senha = (EditText) findViewById(R.id.input_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login login = new Login();
                login.setSenha(senha.getText().toString());
                login.setUsuario(email.getText().toString());
                new LoginTask(LoginActivity.this, login).execute();
            }
        });
    }

    public void addNovoUsuario(View view){
        Intent addNovoUsuario = new Intent(LoginActivity.this,CadastrarUsuarioActivity.class);
        startActivity(addNovoUsuario);
    }


}
