package com.deadely.itl_en.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.App
import com.deadely.itl_en.base.mvp.IBaseProgressView
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity(), IBaseProgressView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityComponent = App.instance.component.activityComponent(ActivityModule(this))
        inject(activityComponent!!)
    }

    protected abstract fun inject(activityComponent: ActivityComponent)

    override fun startLoading() {
    }

    override fun completeLoading() {
    }

    override fun errorLoading() {
    }
}