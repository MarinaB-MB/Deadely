package com.deadely.itl_en.ui.auth

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.base.mvp.IBaseProgressView

interface IAuthContract {
    interface View : IBaseMvpView, IBaseProgressView {
        fun openMainScreen()
        fun showMessage(msg: String)
        fun checkFieldsWithDB(): Boolean
        fun openRegScreen()
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun findUser(email: String)
        fun compareUserDate(email: String, pass: String): Boolean
    }
}