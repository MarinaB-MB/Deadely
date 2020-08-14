package com.deadely.itl_en.network

import com.deadely.itl_en.dataclasses.*
import retrofit2.Call
import retrofit2.http.*


interface IRestDBService {

    @GET("data/{objectId}")
    fun getDataById(@Path("objectId") id: String): Call<Data>

    @POST("data")
    fun newData(@Body data: DataRequestBody): Call<Data>

    //user response

    @GET("users")
    open fun getUsers(): Call<MutableList<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: String): Call<User>

    @DELETE("users/{id}")
    fun deleteUserById(@Path("id") id: String): Call<User>

    @POST("users")
    fun createUser(@Body RequestBody: UserRequestBody): Call<User>

    @PUT("users/{objectId}")
    fun updateUser(@Path("objectId") id: String,
                   @Body put: UserRequestBody): Call<User>

    //group response

    @GET("group")
    fun getGroups(): Call<MutableList<Group>>

    @GET("group/{id}")
    fun getGroupById(@Path("id") id: String): Call<Group>

    @GET("stat")
    fun getStats(): Call<MutableList<Stat>>

    @GET("word")
    fun getWords(): Call<MutableList<Words>>

    @GET("lesson")
    fun getLessons(): Call<MutableList<Lesson>>

}