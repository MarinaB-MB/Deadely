package com.deadely.itl_en.ui.study

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.dataclasses.Group

interface IStudyContract {
    interface View : IBaseMvpView {
        fun showMessage(msg: String)
        fun initData(list: MutableList<Group>)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getGroup()
    }
}