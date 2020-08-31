package com.example.fb.network

import com.example.fb.model.Group
import com.example.fb.model.User
import retrofit2.http.*

interface RestAPI {
    @GET("users/{objectId}")
    suspend fun getUserById(@Path("id") id: String): User

    @GET("users")
    suspend fun getUserByEmail(@Path("q") email: String): User

    @POST("users")
    suspend fun createUser(@Body newUser: User)

    @PUT("users/{objectId}")
    suspend fun updateUser(@Path("objectId") id: String, @Body updatedFields: User)

    @DELETE("users/{id}")
    suspend fun deleteUserById(@Path("id") id: String)

    @GET("word")
    suspend fun getWords(): List<Group.Lesson.Word>

    @GET("group")
    suspend fun getGroups(): List<Group>
}
