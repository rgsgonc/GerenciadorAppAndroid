package br.com.fean.gerenciadorfinanceiro;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;

/**
 * Created by rafael on 16/11/17.
 */

public class LoginTask extends AsyncTask<Void,Void,Boolean> {

    private ProgressDialog progressDialog;
    private Context context;
    private Login login;


    public LoginTask(Context context, Login login) {
        this.context = context;
        this.login = login;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Aguarde....");
        progressDialog.setMessage("Estamos conectando em nossos servidores");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        Boolean autenticouUsuario = sendPOST();
        return autenticouUsuario ;
    }

    private Boolean sendPOST()  {

        Boolean responseBody = null;

        try {

            Call<Boolean> postUsuario = ApiClient.getClientWithGson()
                    .newBuilder().build().create(LoginInterface.class).autentica(login);

            responseBody = postUsuario.execute().body();

        } catch (Exception e){
            e.printStackTrace();
            Log.e("LoginTask", e.getMessage());
        }

        return responseBody;
    }

    @Override
    protected void onPostExecute(Boolean autenticoUsuario) {
        progressDialog.dismiss();

        if(autenticoUsuario){
            Intent intent = new Intent(context, TelaInicialActivity.class);
            context.startActivity(intent);
        } else{
            Toast.makeText(context, "Usuario não existe e/ou usuario e senha estão incorretos!", Toast.LENGTH_SHORT).show();
        }

    }
}
