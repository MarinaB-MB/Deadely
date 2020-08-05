package com.deadely.itl_en.ui.vocab

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.dataclasses.Words

interface IVocabContract {
    interface View : IBaseMvpView {
        fun showMessage(msg: String)
        fun initData(list: MutableList<Words>)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getWords()
    }
}