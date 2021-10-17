package com.on.fsp.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
    suspend fun getLocations() = apiService.getLocations()
    suspend fun getQuotes() = apiService.getQuotes()

}