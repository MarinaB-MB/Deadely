package com.deadely.itl_en.ui.auth.view

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deadely.itl_en.model.User
import com.deadely.itl_en.repository.Repository
import com.deadely.itl_en.utils.DataState
import com.deadely.itl_en.utils.Event
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(
        private val repository: Repository,
        @Assisted
        private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val mUsers = MutableLiveData<DataState<List<User>>>()
    lateinit var email: String
    lateinit var user: User

    fun setEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                is Event.addUser -> {
                    repository.addUser(user)
                }
                is Event.getUserByEmail -> {
                    repository.getUserByEmailFromApi(email).onEach { event ->
                        subscribeData(event)
                    }.launchIn(viewModelScope)
                }
            }
        }
    }

    private fun subscribeData(dataState: DataState<List<User>>) {
        when (dataState) {
            is DataState.Loading -> {
                mUsers.postValue(DataState.Loading)
            }
            is DataState.Success -> {
                mUsers.postValue(DataState.Success(dataState.data))
            }
            is DataState.Error -> {
                mUsers.postValue(DataState.Error(dataState.exception))
            }
        }
    }
}