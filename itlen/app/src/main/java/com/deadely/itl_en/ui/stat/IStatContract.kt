package com.deadely.itl_en.ui.stat

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.base.mvp.IBaseProgressView
import com.deadely.itl_en.dataclasses.Stat

interface IStatContract {
    interface View : IBaseProgressView, IBaseMvpView {
        fun showMessage(msg: String)
        fun initData(list: MutableList<Stat>)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getStat()
    }
}