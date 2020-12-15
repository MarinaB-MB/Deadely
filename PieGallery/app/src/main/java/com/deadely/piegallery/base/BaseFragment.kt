package com.deadely.piegallery.base

import android.os.Bundle
import android.view.View
import moxy.MvpAppCompatFragment

abstract class BaseFragment(layout: Int) : MvpAppCompatFragment(layout), BaseView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExtras()
        setListeners()
        initView()
    }

    abstract fun setListeners()
    abstract fun getExtras()
    abstract fun initView()
}
