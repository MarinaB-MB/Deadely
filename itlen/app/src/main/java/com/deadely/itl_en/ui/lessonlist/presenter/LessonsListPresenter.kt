package com.deadely.itl_en.ui.lessonlist.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.dataclasses.Lesson
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.lessonlist.ILessonsListContract
import javax.inject.Inject

class LessonsListPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<ILessonsListContract.View>(), ILessonsListContract.Presenter {

    private var list: List<Lesson>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
    }

    override fun getLessonsListByGroup(_id: String) {
        list = db.groupDao().getGroupById(_id).lessons
        list?.let { getMvpView()?.setData(it) }
    }

    //
//    override fun getLessonsListRequest() {
//        val call = apiInterface.getLessons()
//        call.enqueue(object : retrofit2.Callback<MutableList<Lesson>> {
//            override fun onResponse(call: Call<MutableList<Lesson>>, response: Response<MutableList<Lesson>>) {
//                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
//                    list = response.body()!!
//                    db.lessonDao().addList(list)
//                    getMvpView()?.setData(list)
//                } else {
//                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
//                }
//            }
//
//            override fun onFailure(call: Call<MutableList<Lesson>>, t: Throwable) {
//
//            }
//
//        })
//    }
}
