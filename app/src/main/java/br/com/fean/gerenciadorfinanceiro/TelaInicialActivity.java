package br.com.fean.gerenciadorfinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class TelaInicialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
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
            Intent novaTransacao = new Intent(TelaInicialActivity.this, CadastrarTransacaoActivity.class);
            startActivity(novaTransacao);
            return(true);
        case R.id.grafico:
            Intent grafico = new Intent(TelaInicialActivity.this, GraficoActivity.class);
            startActivity(grafico);
            return(true);
        case R.id.about:
            Intent sobre = new Intent(TelaInicialActivity.this, SobreActivity.class);
            startActivity(sobre);
            return(true);
        case R.id.exit:
            //add the function to perform here
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }


 /*   public void adicionarTransacao(View view){
        Intent adicionarTransacao = new Intent(TelaInicialActivity.this,CadastrarTransacaoActivity.class);
        startActivity(adicionarTransacao);
    }*/

}
