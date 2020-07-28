package com.deadely.itl_en.main.auth.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick
import com.deadely.itl_en.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initView()
    }

    companion object {
        const val TAG: String = "AuthActivity.TAG"
    }

    private fun initView() {

    }

    @OnClick(R.id.btnAuth)
    fun onClick(view: View) {
        Log.e(TAG, "onClick: Clicked")
    }

}