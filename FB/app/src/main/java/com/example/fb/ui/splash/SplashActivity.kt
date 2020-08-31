package com.example.fb.ui.splash

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.fb.R
import com.example.fb.utils.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity(R.layout.activity_splash) {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.mUser.observe(this, Observer {
            when (it) {
                is DataState.Loading -> {
                    Log.e("TAG", "initObserver: loading")
                }
                is DataState.Error -> {
                    Log.e("TAG", "initObserver: error")
                    Log.e("TAG", it.exception.localizedMessage)
                    openAuthScreen()
                }

                is DataState.Success -> {
                    Log.e("TAG", "initObserver: success")
                    Log.e("TAG", "${it.data}")
                    openMainScreen()
                }
            }
        })
    }

    private fun openAuthScreen() {
        Log.e("TAG", "openAuthScreen")
    }

    private fun openMainScreen() {
        Log.e("TAG", "openAuthScreen")
    }

}