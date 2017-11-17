package br.com.fean.gerenciadorfinanceiro;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;

/**
 * Created by rafael on 16/11/17.
 */

public class CategoriaTask extends AsyncTask<Void,Void,Categoria> {

    private ProgressDialog progressDialog;
    private Context context;
    private Categoria categoria;

    public CategoriaTask(Context context, Categoria categoria) {
        this.context = context;
        this.categoria = categoria;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Aguarde....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Categoria doInBackground(Void... voids) {
        Categoria mensagem = sendPOST();
        return mensagem ;
    }

    private Categoria sendPOST()  {

        Categoria responseBody = null;

        try {

            Call<Categoria> postCategoria = ApiClient.getClientWithGson()
                    .newBuilder().build().create(CategoriaInterface.class).cadastro(categoria);

            responseBody = postCategoria.execute().body();

        } catch (Exception e){
            e.printStackTrace();
            Log.e("CategoriaTask", e.getMessage());
        }

        return responseBody;
    }

    @Override
    protected void onPostExecute(Categoria categoria) {
        progressDialog.dismiss();
        Toast.makeText(context, categoria.getNomeCategoria()+" cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
