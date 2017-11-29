package br.com.fean.gerenciadorfinanceiro;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by rafael on 16/11/17.
 */

public class CategoriaDeleteTask extends AsyncTask<Void,Void,String> {

    private ProgressDialog progressDialog;
    private Context context;
    private Categoria categoria;

    public CategoriaDeleteTask(Context context, Categoria categoria) {
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
    protected String doInBackground(Void... voids) {
        String mensagem = sendPOST();
        return mensagem ;
    }

    private String sendPOST()  {

        String responseBody = null;

        try {

            Call<String>call = ApiClient.getClientWithGson().create(CategoriaInterface.class).delete(categoria.getId());

            responseBody = call.execute().body();

        } catch (Exception e){
            e.printStackTrace();
            Log.e("CategoriaTask", e.getMessage());
        }
        return responseBody;
    }

    @Override
    protected void onPostExecute(String msg) {
        progressDialog.dismiss();
        Toast.makeText(context, msg , Toast.LENGTH_SHORT).show();
        AppCompatActivity activty = (AppCompatActivity) this.context;
        activty.recreate();

    }
}
