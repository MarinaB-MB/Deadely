package com.deadely.itl_en.ui.stat.presenter

import android.os.Bundle
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.stat.IStatContract
import javax.inject.Inject

class StatPresenter @Inject constructor(private var db: AppDatabase, private var apiInterface: IRestDBService) : BasePresenter<IStatContract.View>(), IStatContract.Presenter {
    private lateinit var ud: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ud = db.userDao()
    }
}

