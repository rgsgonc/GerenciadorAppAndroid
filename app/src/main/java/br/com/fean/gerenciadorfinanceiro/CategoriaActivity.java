package br.com.fean.gerenciadorfinanceiro;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

    }

    @Override
    protected void onResume() {
        super.onResume();

        setupListView();
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
            ListView listaDeCategorias = (ListView) findViewById(R.id.lista_categoria);
            ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(context,  android.R.layout.simple_list_item_1, categorias);
            listaDeCategorias.setAdapter(adapter);
        }
    }
}
