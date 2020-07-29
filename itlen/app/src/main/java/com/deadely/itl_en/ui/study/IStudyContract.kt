package com.deadely.itl_en.ui.study

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IStudyContract {
    interface View : IBaseMvpView {
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
    }
}