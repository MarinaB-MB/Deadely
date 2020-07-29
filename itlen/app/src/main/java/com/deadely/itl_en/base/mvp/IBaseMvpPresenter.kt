package com.deadely.itl_en.base.mvp


interface IBaseMvpPresenter<V : IBaseMvpView> {
    fun attachView(mvpView: V)

    fun detachView()
}
