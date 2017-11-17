package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CadastrarCategoriaActivity extends AppCompatActivity {
    private Button btnCadastrarCategoria;
    private EditText nomeCategoria, orcamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_categoria);

        btnCadastrarCategoria = (Button) findViewById(R.id.btn_cadastrar_categoria);
        nomeCategoria = (EditText) findViewById(R.id.input_nome_categoria);
        orcamento = (EditText) findViewById(R.id.input_orcamento_mensal);

        btnCadastrarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Categoria categoria = new Categoria();

                categoria.setNomeCategoria(nomeCategoria.getText().toString());
                categoria.setOrcamento(Double.parseDouble(orcamento.getText().toString()));

                new CategoriaTask(v.getContext(), categoria).execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; thhhis adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.add:
            Intent novaTransacao = new Intent(CadastrarCategoriaActivity.this, CadastrarTransacaoActivity.class);
            startActivity(novaTransacao);
            return(true);
        case R.id.grafico:
            Intent grafico = new Intent(CadastrarCategoriaActivity.this, GraficoActivity.class);
            startActivity(grafico);
            return(true);
        case R.id.about:
            Intent sobre = new Intent(CadastrarCategoriaActivity.this, SobreActivity.class);
            startActivity(sobre);
            return(true);
        case R.id.cadastrar_categoria:
            Intent cadastrarCategoria = new Intent(this, CadastrarCategoriaActivity.class);
            startActivity(cadastrarCategoria);
            return(true);
        case R.id.exit:
            //add the function to perform here
            return(true);
        case R.id.home:
            Intent home = new Intent(CadastrarCategoriaActivity.this, TelaInicialActivity.class);
            startActivity(home);
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }


}
