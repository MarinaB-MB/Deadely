package com.deadely.piegallery.base

import android.os.Bundle

interface IBaseMvpPresenter<V : IBaseMvpView?> {
    fun onCreate(savedInstanceState: Bundle?)
    fun setArguments(vararg objects: Any?)
    fun attachView(mvpView: V)
    fun detachView()
}
