package com.deadely.itl_en.ui.stat

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.base.mvp.IBaseProgressView

interface IStatContract {
    interface View : IBaseProgressView, IBaseMvpView {
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getStat()

    }
}