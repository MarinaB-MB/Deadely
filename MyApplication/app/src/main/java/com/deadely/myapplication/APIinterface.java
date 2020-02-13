package com.deadely.myapplication;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("movies")
    Call<MoviesResponse> getMoviesResponses();


}