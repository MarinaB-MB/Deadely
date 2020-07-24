package com.deadely.itl_en

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick

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

    @OnClick(R.id.btnGo)
    fun onClick(view: View) {
        Log.d(TAG, "onClick: Clicked")
    }

}