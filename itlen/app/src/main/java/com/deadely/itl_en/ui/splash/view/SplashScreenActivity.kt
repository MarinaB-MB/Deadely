package com.deadely.itl_en.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.R
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen) {

    private val viewModel: SplashViewModel by viewModels()

    @Inject
    lateinit var ud: UserDao

    companion object {
        const val TAG = "SplashScreenActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        checkUser()
    }

    private fun checkUser() {
        Log.e(TAG, ud.getAllUsers()[0]._id.toString())
        viewModel.getActiveUser()
        if (viewModel.mUser != null) {
            openMainScreen()
        } else {
            openAuthScreen()
        }
    }

    private fun openAuthScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    private fun openMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}