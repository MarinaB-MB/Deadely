package com.deadely.itl_en.ui.lessonlist

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView
import com.deadely.itl_en.dataclasses.Lesson

interface ILessonsListContract {

    interface View : IBaseMvpView {
        fun setData(list: List<Lesson>)
        fun showMessage(msg: String)
    }

    interface Presenter : IBaseMvpPresenter<View> {
        fun getLessonsListByGroup(_id: String)
    }
}