package br.com.fean.gerenciadorfinanceiro;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CategoriaActivity extends AppCompatActivity {
    private ListView listaDeCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        listaDeCategorias = (ListView) findViewById(R.id.lista_categoria);
        registerForContextMenu(listaDeCategorias);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categoria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.add:
            Intent novaTransacao = new Intent(CategoriaActivity.this, CadastrarCategoriaActivity.class);
            startActivity(novaTransacao);
            return(true);
        case R.id.grafico:
            Intent grafico = new Intent(CategoriaActivity.this, GraficoActivity.class);
            startActivity(grafico);
            return(true);
        case R.id.about:
            Intent sobre = new Intent(CategoriaActivity.this, SobreActivity.class);
            startActivity(sobre);
            return(true);
        case R.id.lista_categoria:
            Intent listarCategoria = new Intent(CategoriaActivity.this,CategoriaActivity.class);
            startActivity(listarCategoria);
            return(true);
        case R.id.lista_usuario:
            Intent listarUsuario = new Intent(CategoriaActivity.this,UsuarioActivity.class);
            startActivity(listarUsuario);
            return(true);
        case R.id.exit:
            Intent login = new Intent(CategoriaActivity.this,LoginActivity.class);
            startActivity(login);
            return(true);
        case R.id.home:
            Intent home = new Intent(CategoriaActivity.this, TelaInicialActivity.class);
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

    @Override
    public void onCreateContextMenu(final ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo)  {
        MenuItem deletar =  menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Categoria categoria = (Categoria) listaDeCategorias.getItemAtPosition(info.position);
                new CategoriaDeleteTask(CategoriaActivity.this,categoria).execute();
                //Toast.makeText(CategoriaActivity.this, "Deletar a categoria " + categoria.getNomeCategoria(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    private void setupListView() {
        new CategoriaListTask(getApplicationContext()).execute();
    }

    public class CategoriaListTask extends AsyncTask<Void, Void, List<Categoria>> {

        private Context context;

        public CategoriaListTask (Context context){
            this.context = context;
        }

        @Override
        protected List<Categoria> doInBackground(Void... params) {
            List<Categoria> categorias = sendPOST();
            return categorias;
        }

        private List<Categoria> sendPOST()  {
            List<Categoria> responseBody = null;
            try {
                retrofit2.Call<List<Categoria>> listCategorias = ApiClient.getClientWithGson()
                        .newBuilder().build().create(CategoriaInterface.class).list();
                responseBody = listCategorias.execute().body();

            } catch (Exception e){
                Log.e("CategoriaListTask", e.getMessage());
            }
            return responseBody;
        }

        @Override
        protected void onPostExecute(List<Categoria> categorias) {
            listaDeCategorias = (ListView) findViewById(R.id.lista_categoria);
            ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(context,  android.R.layout.simple_list_item_1, categorias);
            listaDeCategorias.setAdapter(adapter);

            listaDeCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Categoria categoria = (Categoria) listaDeCategorias.getItemAtPosition(position);

                    Intent vaiParaListaDeCategoria = new Intent(CategoriaActivity.this, CadastrarCategoriaActivity.class);
                    vaiParaListaDeCategoria.putExtra("categoria", categoria);
                    startActivity(vaiParaListaDeCategoria);
                }
            });
        }
    }

    public void carregaLista(){
        new CategoriaListTask(CategoriaActivity.this).execute();
    }
}
