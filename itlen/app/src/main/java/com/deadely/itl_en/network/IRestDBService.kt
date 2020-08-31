package com.deadely.itl_en.network

import com.deadely.itl_en.model.Group
import com.deadely.itl_en.model.User
import retrofit2.http.*


interface IRestDBService {
    @GET("users/{objectId}")
    suspend fun getUserById(@Path("id") id: String): User

    @GET("users{q}")
    suspend fun getUserByEmail(@Query("q") email: String): List<User>

    @POST("users")
    suspend fun createUser(@Body newUser: User): User

    @PUT("users/{objectId}")
    suspend fun updateUser(@Path("objectId") id: String, @Body updatedFields: User): User

    @DELETE("users/{id}")
    suspend fun deleteUserById(@Path("id") id: String)

    @GET("word")
    suspend fun getWords(): List<Group.Lesson.Word>

    @GET("group")
    suspend fun getGroups(): List<Group>
}