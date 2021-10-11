package com.on.fsp.data.api

import com.on.fsp.data.model.Location
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import com.on.fsp.data.model.User

interface ApiService {

    @GET("character")
    suspend fun getUsers(): List<User>

    @GET("character/{userId}")
    suspend fun getUser(@Path("userId") userId: String): User

    @GET("location")
    suspend fun getLocations(): List<Location>
    @GET("location/{userId}")
    suspend fun getLocation(@Path("locationId") locationId: String): Location
}