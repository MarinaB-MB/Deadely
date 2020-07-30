package com.deadely.itl_en.ui.splash.presenter

import android.util.Log
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SplashScreenPresenter : BasePresenter<ISplashScreenContract.View>, ISplashScreenContract.Presenter {
    private var apiInterface: IRestDBService
    private lateinit var ud: UserDao

    @Inject
    constructor(apiInterface: IRestDBService) : super() {
        this.apiInterface = apiInterface
    }

    override fun getUsers() {
//        ud = db.userDao()
        val call = apiInterface.getUsers()
        call.enqueue(object : retrofit2.Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                if (response.isSuccessful && !response.body()?.isEmpty()!!) {

                    val users: List<User> = response.body()!!
//                    for (user in users) {
//                        ud.addUser(user)
//                    }
//                    for (user in ud.getAllUsers()) {
//                        Log.e("TAG", "userId: ${user._id}")
//                    }
                } else {
                    Log.e("TAG", "error")
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
            }

        })
    }

    override fun getActiveUser() {

    }
}