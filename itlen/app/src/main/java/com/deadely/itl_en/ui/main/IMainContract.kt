package com.deadely.itl_en.ui.main

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IMainContract {
    interface View : IBaseMvpView {
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
    }
}