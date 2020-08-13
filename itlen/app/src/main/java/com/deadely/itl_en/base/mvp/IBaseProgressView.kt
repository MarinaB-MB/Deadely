package com.deadely.itl_en.base.mvp

interface IBaseProgressView {
    fun startLoading()
    fun completeLoading()
    fun errorLoading()
}