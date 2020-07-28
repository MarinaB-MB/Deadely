package com.deadely.itl_en.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestDBService {
    private val BASE_URL = "https://itldbexample-a04a.restdb.io/rest/"

    fun getClient(): IRestDBService {
        val client = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .build()
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(IRestDBService::class.java)
    }
}