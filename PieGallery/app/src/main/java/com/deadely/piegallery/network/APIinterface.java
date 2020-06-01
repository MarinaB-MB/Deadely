package com.deadely.piegallery.network;

import com.deadely.piegallery.dataclasses.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface {

    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("page") Integer page, @Query("per_page") Integer perPage, @Query("order_by") String orderBy);

    @GET("photos/{id}")
    Call<Photo> getPhoto(@Path("id") String id, @Query("w") Integer width, @Query("h") Integer height);
}
