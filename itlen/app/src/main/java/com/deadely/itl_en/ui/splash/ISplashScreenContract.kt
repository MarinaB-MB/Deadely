package com.deadely.itl_en.ui.splash

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface ISplashScreenContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun openAuthScreen()
        fun openRegScreen()
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getUsers()
        fun getActiveUser()
    }
}