package br.com.fean.gerenciadorfinanceiro;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class UsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
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
            Intent novaTransacao = new Intent(UsuarioActivity.this, CadastrarUsuarioActivity.class);
            startActivity(novaTransacao);
            return(true);
        case R.id.grafico:
            Intent grafico = new Intent(UsuarioActivity.this, GraficoActivity.class);
            startActivity(grafico);
            return(true);
        case R.id.about:
            Intent sobre = new Intent(UsuarioActivity.this, SobreActivity.class);
            startActivity(sobre);
            return(true);
        case R.id.lista_categoria:
            Intent listarUsuario = new Intent(UsuarioActivity.this,UsuarioActivity.class);
            startActivity(listarUsuario);
            return(true);
        case R.id.exit:
            Intent login = new Intent(UsuarioActivity.this,LoginActivity.class);
            startActivity(login);
            return(true);
        case R.id.home:
            Intent home = new Intent(UsuarioActivity.this, TelaInicialActivity.class);
            startActivity(home);
            return(true);
    }
        return(super.onOptionsItemSelected(item));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupListView();
    }

    private void setupListView() {
        new UsuarioActivity.UsuarioListTask(getApplicationContext()).execute();
    }

    public class UsuarioListTask extends AsyncTask<Void, Void, List<Usuario>> {

        private Context context;
        private ListView listaDeUsuarios;

        public UsuarioListTask(Context context) {
            this.context = context;
        }

        @Override
        protected List<Usuario> doInBackground(Void... params) {
            List<Usuario> usuarios = sendPOST();
            return usuarios;
        }

        private List<Usuario> sendPOST() {
            List<Usuario> responseBody = null;
            try {
                retrofit2.Call<List<Usuario>> listUsuarios = ApiClient.getClientWithGson()
                        .newBuilder().build().create(UsuarioInterface.class).list();
                responseBody = listUsuarios.execute().body();

            } catch (Exception e) {
                Log.e("UsuarioListTask", e.getMessage());
            }
            return responseBody;
        }

        @Override
        protected void onPostExecute(List<Usuario> usuarios) {
            listaDeUsuarios = (ListView) findViewById(R.id.lista_usuario);
            ArrayAdapter<Usuario> adapter = new ArrayAdapter<Usuario>(context, android.R.layout.simple_list_item_1, usuarios);
            listaDeUsuarios.setAdapter(adapter);

            listaDeUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Usuario usuario = (Usuario) listaDeUsuarios.getItemAtPosition(position);

                    Intent vaiParaListaDeUsuario = new Intent(UsuarioActivity.this, CadastrarUsuarioActivity.class);
                    vaiParaListaDeUsuario.putExtra("usuario", usuario);
                    startActivity(vaiParaListaDeUsuario);
                }
            });
        }

    }    
}
