package com.on.fsp.ui.main.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.on.fsp.data.api.ApiHelper
import com.on.fsp.data.api.RetrofitBuilder
import com.on.fsp.data.model.User
import com.on.fsp.data.repository.MainRepository

class UserDetailsViewModel: ViewModel() {

    private val apiHelper = ApiHelper(RetrofitBuilder("https://finalspaceapi.com/api/v0/").apiService)
    //private val appDatabase = AppDatabase.getDatabase()
    private val mainRepository: MainRepository = MainRepository(apiHelper/*, appDatabase*/)
    private val _user = MutableLiveData<User?>(null)
    val user: LiveData<User?> = _user

    fun loadUserInfo(id: String) = viewModelScope.launch {
        val result = mainRepository.getUser(id)
        _user.postValue(result)
    }
}