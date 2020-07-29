package com.deadely.itl_en.ui.splash

interface ISplashScreenContract {
    interface View {
        fun openMainScreen()
        fun openAuthScreen()
        fun openRegScreen()
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun getUsers()
        fun getActiveUser()
    }
}