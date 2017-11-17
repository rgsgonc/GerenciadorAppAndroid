package br.com.fean.gerenciadorfinanceiro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by rafael on 17/11/17.
 */

public interface LoginInterface {

    @POST("login/autenticacao")
    @Headers("Content-Type: application/json")
    Call<Boolean> autentica(@Body Login login);
}
