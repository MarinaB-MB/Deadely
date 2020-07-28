package com.deadely.itl_en.main.reg

interface IRegContract {
    interface View {
        fun openMainScreen()
        fun showMessage(msg: String)
    }

    interface Presenter {
    }
}