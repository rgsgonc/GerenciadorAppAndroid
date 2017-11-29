package br.com.fean.gerenciadorfinanceiro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by rafael on 16/11/17.
 */

public interface CategoriaInterface {

    //la no eclipse CategoriaController.
    @POST("categoria/cadastro")
    @Headers("Content-Type: application/json")
    Call<Categoria> cadastro(@Body Categoria categoria);

    @GET("categoria/list")
    Call<List<Categoria>> list();

    @PUT("categoria/update")
    @Headers("Content-Type: application/json")
    Call<Categoria> update(@Body Categoria categoria);

    @DELETE("categoria/delete/{idCategoria}")
    Call<String> delete(@Path(value = "idCategoria") int idCategoria);

}
