package com.example.fb.ui.study

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.fb.repository.Repository

class StudyViewModel
@ViewModelInject
constructor(
    private var repository: Repository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

}