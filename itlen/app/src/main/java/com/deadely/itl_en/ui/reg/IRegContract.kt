package com.deadely.itl_en.ui.reg

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IRegContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun showMessage(msg: String)
        fun checkFields(): Boolean
        fun openAuthScreen()
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getUsersList(): Boolean
        fun createNewUser(name: String, email: String, password: String, active: Boolean)
        fun clearActiveUser()
    }
}