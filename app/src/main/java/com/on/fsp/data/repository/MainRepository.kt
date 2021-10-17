package com.on.fsp.data.repository

import com.on.fsp.data.api.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
    suspend fun getUser(id: String)= apiHelper.getUser(id)
    suspend fun getLocations() = apiHelper.getLocations()
    suspend fun getQuotes() = apiHelper.getQuotes()

}