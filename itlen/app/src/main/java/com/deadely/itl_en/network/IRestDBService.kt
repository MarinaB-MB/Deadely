package com.deadely.itl_en.network

import com.deadely.itl_en.dataclasses.User
import retrofit2.Call
import retrofit2.http.*


interface IRestDBService {

    //user response

    @GET("users")
    open fun getUsers(): Call<MutableList<User?>?>?

    @GET("users/{id}")
    fun getUserById(@Path("id") id: String?): Call<User?>?

    @POST("users")
    fun createUser(@Body user: User?): Call<User?>?

    @PUT("users/{objectId}")
    fun updateUser(@Path("objectId") id: String?,
                   @Body user: User?): Call<User?>?
}