package br.com.fean.gerenciadorfinanceiro;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;

/**
 * Created by rafael on 16/11/17.
 */

public class UsuarioTask extends AsyncTask<Void,Void,Usuario> {

    private ProgressDialog progressDialog;
    private Context context;
    private Usuario usuario;

    public UsuarioTask(Context context, Usuario usuario) {
        this.context = context;
        this.usuario = usuario;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Aguarde....");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Usuario doInBackground(Void... voids) {
        Usuario mensagem = sendPOST();
        return mensagem ;
    }

    private Usuario sendPOST()  {

        Usuario responseBody = null;

        try {
            Call<Usuario> call = null;

            if(usuario.getId() !=  0){
                call = ApiClient.getClientWithGson()
                        .newBuilder().build().create(UsuarioInterface.class).update(usuario);
            }else{
                call = ApiClient.getClientWithGson()
                        .newBuilder().build().create(UsuarioInterface.class).cadastro(usuario);
            }

            responseBody = call.execute().body();

        } catch (Exception e){
            e.printStackTrace();
            Log.e("UsuarioTask", e.getMessage());
        }

        return responseBody;
    }

    @Override
    protected void onPostExecute(Usuario usuario) {
        progressDialog.dismiss();
        try{
            if(usuario.getId() != 0){
                Toast.makeText(context, usuario.getNome()+" alterado com sucesso!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, usuario.getNome()+" cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(context,"Ops.. Temos um problema! Tente novamente!", Toast.LENGTH_SHORT).show();
        }
        Intent intentVaiParaLista = new Intent(context, UsuarioActivity.class);
        context.startActivity(intentVaiParaLista);
        AppCompatActivity activity = (AppCompatActivity) this.context;
        activity.finish();
    }
}
