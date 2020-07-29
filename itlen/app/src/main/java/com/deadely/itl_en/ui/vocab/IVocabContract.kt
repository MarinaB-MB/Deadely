package com.deadely.itl_en.ui.vocab

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface IVocabContract {
    interface View : IBaseMvpView {
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
    }
}