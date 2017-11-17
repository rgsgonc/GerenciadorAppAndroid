package br.com.fean.gerenciadorfinanceiro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by rafael on 16/11/17.
 */

public interface CategoriaInterface {

    @POST("categoria/cadastro")
    @Headers("Content-Type: application/json")
    Call<Categoria> cadastro(@Body Categoria categoria);

}
