package com.deadely.itl_en.ui.reg

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IRegContract {
    interface View : IBaseMvpView {
        fun openMainScreen()
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
    }
}