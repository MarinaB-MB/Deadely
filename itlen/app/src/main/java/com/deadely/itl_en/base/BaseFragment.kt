package com.deadely.itl_en.base

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.deadely.itl_en.App
import com.deadely.itl_en.base.mvp.IBaseProgressView
import com.deadely.itl_en.di.component.FragmentComponent
import com.deadely.itl_en.di.module.FragmentModule

abstract class BaseFragment : Fragment(), IBaseProgressView {

    private var progressBar: ProgressBar? = null
    protected abstract val progressView: ProgressBar?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentComponent = App.instance.component.fragmentComponent(FragmentModule(this))
        inject(fragmentComponent)
    }

    private fun initProgressLayout() {
        progressView?.let { progressBar = it }
    }

    abstract fun inject(fragmentComponent: FragmentComponent?)

    override fun startLoading() {
        if (progressBar != null) progressBar?.visibility = VISIBLE
    }

    override fun completeLoading() {
        if (progressBar != null) progressBar?.visibility = GONE
    }

    override fun errorLoading() {
        if (progressBar != null) progressBar?.visibility = GONE
    }
}