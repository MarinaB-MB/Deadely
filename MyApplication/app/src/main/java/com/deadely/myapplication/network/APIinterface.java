package com.deadely.myapplication.network;

import com.deadely.myapplication.dataclass.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("movies")
    Call<MoviesResponse> getMoviesResponses();


}