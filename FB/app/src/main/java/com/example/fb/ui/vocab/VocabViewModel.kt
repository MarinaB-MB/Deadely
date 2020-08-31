package com.example.fb.ui.vocab

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.fb.model.Group
import com.example.fb.model.User
import com.example.fb.network.RestAPI
import com.example.fb.repository.Repository
import kotlinx.coroutines.launch

class VocabViewModel
@ViewModelInject
constructor(
    private var repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}