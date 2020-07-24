package com.deadely.itl_en

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        actionBar?.hide()

        openMainScreen()
    }

    private fun openMainScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
    }
}