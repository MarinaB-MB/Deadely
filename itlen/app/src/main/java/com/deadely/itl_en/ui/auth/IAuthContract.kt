package com.deadely.itl_en.ui.auth

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