package com.deadely.itl_en.ui.auth

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IAuthContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun showMessage(msg: String)
        fun checkFieldsWithDB(): Boolean
        fun openRegScreen()
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun compareUserDate(email: String, pass: String): Boolean
    }
}