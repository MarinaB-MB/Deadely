package com.deadely.itl_en.ui.splash.view

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deadely.itl_en.model.User
import com.deadely.itl_en.repository.Repository
import kotlinx.coroutines.launch

class SplashViewModel @ViewModelInject constructor(
        private val repository: Repository
) : ViewModel() {

    var mUser: User? = null


    fun getActiveUser() {
        viewModelScope.launch {
            mUser = repository.getActiveUser()
        }
    }
}