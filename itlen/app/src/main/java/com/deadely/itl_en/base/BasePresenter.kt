package com.deadely.itl_en.base

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView


class BasePresenter<T : IBaseMvpView> : IBaseMvpPresenter<T> {

    protected var mMvpView: T? = null

    fun attachView(mvpView: T) {
        mMvpView = mvpView
    }

    fun detachView() {
        mMvpView = null
    }

    fun getMvpView(): T? {
        return mMvpView
    }
}