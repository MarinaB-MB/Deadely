package com.deadely.itl_en.ui.stat.presenter

import android.os.Bundle
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.Stat
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.stat.IStatContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class StatPresenter @Inject constructor(private var db: AppDatabase, private var apiInterface: IRestDBService) : BasePresenter<IStatContract.View>(), IStatContract.Presenter {
    private lateinit var ud: UserDao
    private lateinit var list: MutableList<Stat>
    override fun getStat() {
        val call = apiInterface.getStats()
        call.enqueue(object : retrofit2.Callback<MutableList<Stat>> {
            override fun onResponse(call: Call<MutableList<Stat>>, response: Response<MutableList<Stat>>) {
                if (response.isSuccessful || !response.body().isNullOrEmpty()) {
                    list = response.body()!!
                    for (stat in list) {
                        db.statDao().addStat(stat)
                    }
//                    getMvpView()?.initData(list)
                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
                }
            }

            override fun onFailure(call: Call<MutableList<Stat>>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString())
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ud = db.userDao()
    }
}

