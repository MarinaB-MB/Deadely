package com.deadely.itl_en.base.mvp

import android.os.Bundle


interface IBaseMvpPresenter<V : IBaseMvpView> {
    fun onCreate(savedInstanceState: Bundle?)
    fun attachView(mvpView: V)
    fun detachView()
}
