package com.deadely.itl_en.ui.auth

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IAuthContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun showMessage(msg: String)
        fun checkFields(): Boolean
        fun authUser()
    }

    interface Presenter : IBaseMvpPresenter<View> {
    }
}