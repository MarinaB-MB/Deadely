package com.deadely.itl_en.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.view.RegActivity
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import javax.inject.Inject


class SplashScreenActivity : BaseActivity(), ISplashScreenContract.View {

    @Inject
    lateinit var presenter: ISplashScreenContract.Presenter

    companion object {
        const val TAG = "SplashScreenActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        presenter.attachView(this)
        presenter.getUsers()
    }

    override fun openRegScreen() {
        startActivity(Intent(this, RegActivity::class.java))
        finish()
    }

    override fun openAuthScreen() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun openMainScreen() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

}
