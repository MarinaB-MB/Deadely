package com.deadely.itl_en.ui.study.presenter

import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.dataclasses.Group
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.study.IStudyContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class StudyPresenter @Inject constructor(var apiInterface: IRestDBService, var db: AppDatabase) : BasePresenter<IStudyContract.View>(), IStudyContract.Presenter {
    lateinit var list: MutableList<Group>
    override fun getGroup() {
        db.groupDao().deleteAllGroup()

        val call = apiInterface.getGroups()
        call.enqueue(object : retrofit2.Callback<MutableList<Group>> {
            override fun onResponse(call: Call<MutableList<Group>>, response: Response<MutableList<Group>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    for (group in list) {
                        db.groupDao().addGroup(group)
                    }
                    getMvpView()?.initData(list)
                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
                }
            }

            override fun onFailure(call: Call<MutableList<Group>>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString())
            }
        })
    }

}

