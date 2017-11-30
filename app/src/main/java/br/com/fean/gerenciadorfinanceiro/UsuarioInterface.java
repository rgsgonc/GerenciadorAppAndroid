package br.com.fean.gerenciadorfinanceiro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by rafael on 16/11/17.
 */

public interface UsuarioInterface {
    //la no eclipse UsuarioController.
    @POST("usuario/cadastro")
    @Headers("Content-Type: application/json")
    Call<Usuario> cadastro(@Body Usuario usuario);

    @GET("usuario/list")
    Call<List<Usuario>> list();

    @PUT("usuario/update")
    @Headers("Content-Type: application/json")
    Call<Usuario> update(@Body Usuario usuario);

    @DELETE("usuario/delete/{idUsuario}")
    Call<String> delete(@Path(value = "idUsuario") int idUsuario);
}
