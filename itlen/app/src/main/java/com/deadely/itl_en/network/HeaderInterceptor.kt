package com.deadely.itl_en.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class HeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .addHeader("x-api-key", "0362370bf456d10a726b0512630d30863132b")
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .build()
        return chain.proceed(request)
    }
}
