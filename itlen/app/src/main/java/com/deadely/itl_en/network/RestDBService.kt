package com.deadely.itl_en.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestDBService {
    private val BASE_URL = "https://itldbexample-a04a.restdb.io/rest/"
    private lateinit var apiInterface: IRestDBService

    private fun getClient(): IRestDBService? {

        var client = OkHttpClient()
        client = OkHttpClient.Builder()
                .addInterceptor(HeaderInterceptor())
                .build()

        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface = retrofit.create(IRestDBService::class.java)
        return apiInterface
    }

    fun apIinterface(): IRestDBService? {
        return getClient()
    }
}