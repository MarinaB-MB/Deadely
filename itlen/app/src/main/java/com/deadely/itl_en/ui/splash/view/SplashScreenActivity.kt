package com.deadely.itl_en.ui.splash.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.view.RegActivity
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import com.deadely.itl_en.utils.PreferencesManager
import com.deadely.itl_en.utils.PreferencesManager.get
import com.deadely.itl_en.utils.PreferencesManager.set
import javax.inject.Inject


class SplashScreenActivity : BaseActivity(), ISplashScreenContract.View {

    //    private lateinit var intentFilter: IntentFilter
//    val broadcastAction = "android.net.conn.CONNECTIVITY_CHANGE"
    private val FIRST_SIGNIN = "firstSignIn"
    private var firstSignIn: Boolean = false
    private lateinit var preferences: SharedPreferences
//    val preferences = PreferencesManager()

    @Inject
    lateinit var presenter: ISplashScreenContract.Presenter

    companion object {
        const val TAG = "SplashScreenActivity"
    }

//    private var receiver: BroadcastReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context, intent: Intent) {
//            when (intent.action) {
//                BROADCAST_ACTION -> {
//                    retry()
//                }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun changeState() {
        preferences["isFirstSignIn"] = true
        firstSignIn = preferences["isFirstSignIn", false]!!
        Log.e(TAG, "changeState: $firstSignIn")
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initView() {
        preferences = PreferencesManager.defaultPrefs(this)
        firstSignIn = preferences["isFirstSignIn", false]!!
        Log.e(TAG, "changeState: $firstSignIn")
        presenter.getUser(firstSignIn)
//        intentFilter = IntentFilter(BROADCAST_ACTION)
//        registerReceiver(receiver, intentFilter);
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

//    override fun showConnectionDialog() {
//        val dialog = NoConnectionDialog(this).run { show() }
//    }

//    override fun retry() {
//        if (NetworkInfo().isConnectingAvailable(baseContext)) presenter.getUsers(firstSignIn)
//        else presenter.openConnectionDialog()
//    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(receiver)
    }
}