package br.com.fean.gerenciadorfinanceiro;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by rafael on 16/11/17.
 */

public class ApiClient {

    public static final String BASE_URL = "http://172.20.10.5:8080/GerenciadorFinanceiro/rest/";

    private static Retrofit retrofitGson = null;
    private static Retrofit retrofitJackson = null;

    public static Retrofit getClientWithGson() {
        if (retrofitGson == null) {
            retrofitGson = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitGson;
    }

    public static Retrofit getClientWithJackson() {
        if (retrofitJackson == null) {
            retrofitJackson = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofitJackson;
    }

}
