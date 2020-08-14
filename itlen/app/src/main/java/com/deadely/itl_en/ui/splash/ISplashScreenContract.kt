package com.deadely.itl_en.ui.splash

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface ISplashScreenContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun openAuthScreen()
        fun openRegScreen()
        fun showMessage(msg: String)
        fun retry()
        fun showConnectionDialog()
        fun changeState()
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getUsers(deviceId: String, isFirstSignIn: Boolean)
        fun getActiveUser()
        fun openConnectionDialog()
    }
}