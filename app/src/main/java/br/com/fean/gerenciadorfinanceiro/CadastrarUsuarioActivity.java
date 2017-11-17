package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarUsuarioActivity extends AppCompatActivity {

    private Button btnCadastrarUsuario;
    private EditText nome, endereco,email,telefone,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnCadastrarUsuario = (Button) findViewById(R.id.btn_cadastrar_usuario);
        nome = (EditText) findViewById(R.id.input_nome);
        endereco = (EditText) findViewById(R.id.input_endereco);
        email = (EditText) findViewById(R.id.input_email);
        telefone = (EditText) findViewById(R.id.input_telefone);
        senha = (EditText) findViewById(R.id.input_senha);

        btnCadastrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setTelefone(telefone.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setEndereco(endereco.getText().toString());
                usuario.setSenha(senha.getText().toString());

                new UsuarioTask(v.getContext(), usuario).execute();
            }
        });

    }
}
