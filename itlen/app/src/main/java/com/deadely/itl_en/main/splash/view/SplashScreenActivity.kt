package com.deadely.itl_en.main.splash.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.R
import com.deadely.itl_en.main.auth.view.AuthActivity
import com.deadely.itl_en.main.main.view.MainActivity
import com.deadely.itl_en.main.reg.view.RegActivity
import com.deadely.itl_en.main.splash.ISplashScreenContract

class SplashScreenActivity : AppCompatActivity(), ISplashScreenContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    companion object {
        const val TAG = "SplashScreenActivity"
    }

    private fun initView() {
        openAuthScreen()
    }

    override fun openRegScreen() {
        startActivity(Intent(this, RegActivity::class.java))
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun openAuthScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
    }

    override fun openMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}