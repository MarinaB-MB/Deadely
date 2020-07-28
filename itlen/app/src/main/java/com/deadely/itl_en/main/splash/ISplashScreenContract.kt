package com.deadely.itl_en.main.splash

interface ISplashScreenContract {
    interface View {
        fun openMainScreen()
        fun openAuthScreen()
        fun openRegScreen()
    }

    interface ViewPresenter {}
}