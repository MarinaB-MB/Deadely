package com.deadely.retrofitex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("movies")
    Call<List<Result>> getResults();


}