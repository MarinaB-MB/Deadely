package com.deadely.itl_en.ui.reg

interface IRegContract {
    interface View {
        fun openMainScreen()
        fun showMessage(msg: String)
    }

    interface Presenter {
    }
}