package com.deadely.itl_en.base

import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView


open class BasePresenter<T : IBaseMvpView> : IBaseMvpPresenter<T> {

    private var mMvpView: T? = null

    override fun attachView(mvpView: T) {
        mMvpView = mvpView
    }

    override fun detachView() {
        mMvpView = null
    }

    fun getMvpView(): T? {
        return mMvpView
    }
}