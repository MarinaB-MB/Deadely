package com.example.fb.ui.stat

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fb.network.RestAPI

class StatViewModel
@ViewModelInject
constructor(
    private var api: RestAPI,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
//
//    private val user = MutableLiveData<DataState<List<User>>>()
//
//    init {
//        fetchUsers()
//    }
//
//    private fun fetchUsers() {
//        viewModelScope.launch {
//            user.postValue(DataState.loading(null))
//            try {
//                val usersFromApi = api.getUsers()
//                user.postValue(DataState.success(usersFromApi))
//            } catch (e: Exception) {
//                user.postValue(DataState.error(e.toString(), null))
//            }
//        }
//    }
//
//    fun getUsers(): LiveData<Resource<List<User>>> {
//        return user
//    }
}