package com.on.fsp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder(burl: String) {

    private val BASE_URL = burl//"https://finalspaceapi.com/api/v0/"

    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}