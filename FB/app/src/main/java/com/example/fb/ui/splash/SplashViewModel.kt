package com.example.fb.ui.splash

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fb.model.User
import com.example.fb.repository.Repository
import com.example.fb.utils.DataState
import com.example.fb.utils.Event
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SplashViewModel
@ViewModelInject
constructor(
    private val repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val mUser = MutableLiveData<DataState<User>>()
    val mListUser = MutableLiveData<DataState<List<User>>>()

    init {
        setEvent(Event.getUsersEvent)
    }

    fun setEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                is Event.getUsersEvent -> {
                    repository.getActiveUser().onEach { event ->
                        subscribeData(event)
                    }.launchIn(viewModelScope)
                }
            }
        }
    }

    private fun subscribeData(dataState: DataState<User>) {
        when (dataState) {
            is DataState.Loading -> {
                mUser.postValue(DataState.Loading)
            }
            is DataState.Success -> {
                mUser.postValue(DataState.Success(dataState.data))
            }
            is DataState.Error -> {
                mUser.postValue(DataState.Error(dataState.exception))
            }
        }
    }

}