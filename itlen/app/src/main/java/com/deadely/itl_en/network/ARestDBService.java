package com.deadely.itl_en.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ARestDBService {
    private static String BASE_URL = "https://itldbexample-a04a.restdb.io/rest/";

    public static IRestDBService getClient() {
        OkHttpClient client = new OkHttpClient();
        client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IRestDBService.class);
    }
}
