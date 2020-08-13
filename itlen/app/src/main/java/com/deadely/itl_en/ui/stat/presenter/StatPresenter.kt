package com.deadely.itl_en.ui.stat.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.Stat
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.stat.IStatContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class StatPresenter @Inject constructor(private var db: AppDatabase, private var apiInterface: IRestDBService) : BasePresenter<IStatContract.View>(), IStatContract.Presenter {
    private lateinit var ud: UserDao
    private lateinit var list: MutableList<Stat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ud = db.userDao()
        getStat()
    }

    override fun getStat() {
        getMvpView()?.startLoading()
        val call = apiInterface.getStats()
        call.enqueue(object : retrofit2.Callback<MutableList<Stat>> {
            override fun onResponse(call: Call<MutableList<Stat>>, response: Response<MutableList<Stat>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    for (stat in list) {
                        db.statDao().addStat(stat)
                    }
                    db.statDao().addList(list)
                    getMvpView()?.initData(list)
                    getMvpView()?.completeLoading()
                } else {
                    getMvpView()?.errorLoading()
                }
            }

            override fun onFailure(call: Call<MutableList<Stat>>, t: Throwable) {
                getMvpView()?.errorLoading()
            }
        })
    }
}

