package com.on.fsp.data.api

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.on.fsp.data.model.User

interface ApiService {

    @GET("character")
    suspend fun getUsers(): List<User>

    @GET("character/{userId}")
    suspend fun getUser(@Path("userId") userId: String): User

}