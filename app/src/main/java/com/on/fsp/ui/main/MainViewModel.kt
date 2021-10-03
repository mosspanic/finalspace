package com.on.fsp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.on.fsp.data.api.ApiHelper
import com.on.fsp.data.api.RetrofitBuilder
import com.on.fsp.data.repository.MainRepository
import com.on.fsp.utils.Resource

class MainViewModel : ViewModel() {

    private val apiHelper = ApiHelper(RetrofitBuilder.apiService)
    private val mainRepository: MainRepository = MainRepository(apiHelper)

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
            println("#########Resource.success");   //println("######### ")
            println("####### $mainRepository.getUsers().size")

        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
            println("#########Resource.Exception");
        }
    }
}