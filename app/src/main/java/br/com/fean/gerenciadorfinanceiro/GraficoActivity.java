package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GraficoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.add:
            Intent novaTransacao = new Intent(GraficoActivity.this, CadastrarTransacaoActivity.class);
            startActivity(novaTransacao);
            return(true);
        case R.id.grafico:
            Intent grafico = new Intent(GraficoActivity.this, GraficoActivity.class);
            startActivity(grafico);
            return(true);
        case R.id.about:
            Intent sobre = new Intent(GraficoActivity.this, SobreActivity.class);
            startActivity(sobre);
            return(true);
        case R.id.lista_categoria:
            Intent listaCategoria = new Intent(GraficoActivity.this, CategoriaActivity.class);
            startActivity(listaCategoria);
            return(true);
        case R.id.lista_usuario:
            Intent listarUsuario = new Intent(GraficoActivity.this,UsuarioActivity.class);
            startActivity(listarUsuario);
            return(true);
        case R.id.exit:
            Intent login = new Intent(GraficoActivity.this, LoginActivity.class);
            startActivity(login);
            return(true);
        case R.id.home:
            Intent home = new Intent(GraficoActivity.this, TelaInicialActivity.class);
            startActivity(home);
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }

}
