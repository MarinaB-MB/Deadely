package com.deadely.itl_en.ui.splash.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(private var apiInterface: IRestDBService, private var db: AppDatabase) : BasePresenter<ISplashScreenContract.View>(), ISplashScreenContract.Presenter {

    private lateinit var ud: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ud = db.userDao()
    }

    override fun getUser(isFirstSignIn: Boolean) {
        if (!isFirstSignIn) {
            getMvpView()?.changeState()
            getMvpView()?.openRegScreen()
        } else {
            if (ud.getActiveUser(true) != null) {
                getMvpView()?.openMainScreen()
            } else {
                if (!ud.getAllUsers().isNullOrEmpty()) {
                    getMvpView()?.openAuthScreen()
                } else {
                    getMvpView()?.openRegScreen()
                }
            }
        }
    }

//    override fun getActiveUser() {
//        ud = db.userDao()
//        val user = ud.getActiveUser(true)
//        if (user != null) {
//            getMvpView()?.openMainScreen()
//        } else {
//            getMvpView()?.openAuthScreen()
//        }
//    }
//
//    override fun openConnectionDialog() {
//        getMvpView()?.showConnectionDialog()
//    }
}