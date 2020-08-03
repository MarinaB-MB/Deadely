package com.deadely.itl_en.base

import android.os.Bundle
import com.deadely.itl_en.base.mvp.IBaseMvpPresenter
import com.deadely.itl_en.base.mvp.IBaseMvpView


open abstract class BasePresenter<T : IBaseMvpView> : IBaseMvpPresenter<T> {

    override fun onCreate(savedInstanceState: Bundle?) {
        return
    }

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