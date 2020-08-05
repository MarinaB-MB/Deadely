package com.deadely.itl_en.ui.lessonlist.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.lessonlist.ILessonsListContract
import javax.inject.Inject

class LessonsListPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<ILessonsListContract.View>(), ILessonsListContract.Presenter {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {

    }

}
