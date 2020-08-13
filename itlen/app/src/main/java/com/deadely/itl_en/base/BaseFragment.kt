package com.deadely.itl_en.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.deadely.itl_en.App
import com.deadely.itl_en.base.mvp.IBaseProgressView
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.di.module.FragmentModule

abstract class BaseFragment : Fragment(), IBaseProgressView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentComponent = App.instance.component.fragmentComponent(FragmentModule(this))
        inject(fragmentComponent)
    }

    abstract fun inject(fragmentComponent: FragmentComponent?)

    override fun startLoading() {
    }

    override fun completeLoading() {
    }

    override fun errorLoading() {
    }
}