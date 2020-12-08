package com.deadely.piegallery.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment

abstract class BaseFragment(layout: Int) : MvpAppCompatFragment(layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachPresenter()
        initObserver()
        setListeners()
        initView()
    }

    abstract fun initObserver()
    abstract fun setListeners()
    abstract fun initView()
    abstract fun attachPresenter()
}
