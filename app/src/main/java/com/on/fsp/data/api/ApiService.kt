package com.on.fsp.data.api

import com.on.fsp.data.model.*
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getUsers(): List<User>

    @GET("character/{userId}")
    suspend fun getUser(@Path("userId") userId: String): User

    @GET("location")
    suspend fun getLocations(): List<Location>
    @GET("location/{userId}")
    suspend fun getLocation(@Path("locationId") locationId: String): Location

    @GET("quote")
    suspend fun getQuotes(): List<Quote>

    @GET("episode")
    suspend fun getEpisodes(): List<Episode>
    @GET("episode/{userId}")
    suspend fun getEpisode(@Path("episodeId") episodeId: String): Episode
}