package com.qw73.itfactory.testprojectmvp.network

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://api.npoint.io/"
    var retrofit: Retrofit? = null
    val API_KEY = "05b0db32009fa4e548a3"

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}