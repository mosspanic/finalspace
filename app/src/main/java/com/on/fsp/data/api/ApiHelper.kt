package com.on.fsp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
    suspend fun getUser(id:String) = apiService.getUser(id)
    suspend fun getLocations() = apiService.getLocations()
    suspend fun getQuotes() = apiService.getQuotes()
    suspend fun getEpisodes() = apiService.getEpisodes()
}