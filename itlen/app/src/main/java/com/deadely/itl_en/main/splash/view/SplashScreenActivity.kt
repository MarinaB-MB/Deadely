package com.deadely.itl_en.main.splash.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    companion object {
        const val TAG = "SplashScreenActivity"
    }

    private fun initView() {
        actionBar?.hide()
        openMainScreen()
    }

    private fun openMainScreen() {

//        val call: Call<MutableList<User>> = RestDBService().apIinterface()?.getUsers()!!
//        call.enqueue(object : Callback<MutableList<User>> {
//            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
//                if (response.isSuccessful && !response.body()?.isEmpty()!!) {
//                    Log.e(TAG, "onResponse: isSuccessful")
//                } else {
//                    Log.e(TAG, "onResponse: isSuccessful")
//                }
//            }
//
//            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
//
//            }
//
//        })
//        startActivity(Intent(this, AuthActivity::class.java))
    }
}