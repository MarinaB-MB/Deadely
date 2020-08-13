package com.deadely.itl_en.ui.study.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.dataclasses.Group
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.study.IStudyContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class StudyPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<IStudyContract.View>(), IStudyContract.Presenter {
    lateinit var list: MutableList<Group>
    override fun getGroup() {
        getMvpView()?.startLoading()
        db.groupDao().deleteAllGroup()

        val call = apiInterface.getGroups()
        call.enqueue(object : retrofit2.Callback<MutableList<Group>> {
            override fun onResponse(call: Call<MutableList<Group>>, response: Response<MutableList<Group>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    db.groupDao().addList(list)
                    getMvpView()?.initData(list)
                    getMvpView()?.completeLoading()
                } else {
                    getMvpView()?.errorLoading()
                }
            }

            override fun onFailure(call: Call<MutableList<Group>>, t: Throwable) {
                getMvpView()?.errorLoading()
            }
        })
    }

    override fun openGroupScreen(group: Group) {
        getMvpView()?.showGroupScreen(group)
    }
}

