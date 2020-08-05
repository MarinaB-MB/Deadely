package com.deadely.itl_en.ui.lessonlist

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView

interface ILessonsListContract {

    interface View : IBaseMvpView {

    }

    interface Presenter : IBaseMvpPresenter<View> {

    }
}