package com.deadely.m_v_p.network;

import com.deadely.m_v_p.model.moviesresponseclass.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {

    @GET("movies")
    Call<MoviesResponse> getMoviesResponses();


}