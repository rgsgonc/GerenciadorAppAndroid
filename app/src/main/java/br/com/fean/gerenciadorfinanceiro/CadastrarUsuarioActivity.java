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
    private Usuario usuarioAtual;

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


                Usuario usuarioTela = new Usuario();

                if(usuarioAtual != null){
                    usuarioTela.setId(usuarioAtual.getId());
                }

                usuarioTela.setNome(nome.getText().toString());
                usuarioTela.setEndereco(endereco.getText().toString());
                usuarioTela.setEmail(email.getText().toString());
                usuarioTela.setTelefone(telefone.getText().toString());
                usuarioTela.setSenha(senha.getText().toString());


                new UsuarioTask(v.getContext(), usuarioTela).execute();
                
                

            }
        });

        Intent intentAtivadora = getIntent();
        Usuario usuario = (Usuario) intentAtivadora.getSerializableExtra("usuario");

        if(usuario != null){
            nome.setText(usuario.getNome());
            endereco.setText(usuario.getEndereco());
            email.setText(usuario.getEmail());
            telefone.setText(usuario.getTelefone());
            senha.setText(usuario.getSenha());
            usuarioAtual = usuario;
            btnCadastrarUsuario.setText(R.string.btn_alterar_usuario);
        }

    }
    
    
}
