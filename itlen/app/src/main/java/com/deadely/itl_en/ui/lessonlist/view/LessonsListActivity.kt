package com.deadely.itl_en.ui.lessonlist.view

import android.os.Bundle
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.lessonlist.ILessonsListContract
import javax.inject.Inject

open class LessonsListActivity : BaseActivity(), ILessonsListContract.View {
    @Inject
    lateinit var presenter: ILessonsListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {

    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

}

