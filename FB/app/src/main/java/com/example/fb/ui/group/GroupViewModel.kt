package com.example.fb.ui.group

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fb.network.RestAPI

class GroupViewModel
@ViewModelInject
constructor(
    private var api: RestAPI,

    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
    }
}