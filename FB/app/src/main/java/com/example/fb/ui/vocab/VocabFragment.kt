package com.example.fb.ui.vocab

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VocabFragment : Fragment(R.layout.fragment_vocab) {

    private val viewModel: VocabViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {

    }
}