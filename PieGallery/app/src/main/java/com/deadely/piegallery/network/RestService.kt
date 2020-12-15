package com.deadely.piegallery.network

import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.dataclasses.SearchRequest
import com.deadely.piegallery.dataclasses.UserProfile
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestService {

    @GET("photos")
    fun getPhotos(@Query("page") page: Int?, @Query("per_page") perPage: Int, @Query("order_by") orderBy: String): Single<List<Photo>>

    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: String?, @Query("w") width: Int, @Query("h") height: Int): Single<Photo>

    @GET("search/photos")
    fun searchPhoto(@Query("page") page: Int?, @Query("query") query: String, @Query("per_page") perPage: Int, @Query("order_by") orderBy: String): Single<SearchRequest>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Single<UserProfile>
}
