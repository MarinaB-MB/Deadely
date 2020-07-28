package com.deadely.itl_en.main.auth

interface IAuthContract {
    interface View {
        fun openMainScreen()
        fun showMessage(msg: String)
        fun checkFields(): Boolean
        fun authUser()
    }

    interface Presenter {
    }
}