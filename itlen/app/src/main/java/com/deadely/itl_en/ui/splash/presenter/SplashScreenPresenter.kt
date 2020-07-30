package com.deadely.itl_en.ui.splash.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SplashScreenPresenter : BasePresenter<ISplashScreenContract.View>, ISplashScreenContract.Presenter {
    lateinit var apiInterface: IRestDBService

    @Inject
    constructor(apiInterface: IRestDBService) : super() {
        this.apiInterface = apiInterface
    }


    override fun getUsers() {
        val call = apiInterface.getUsers()
        call.enqueue(object : retrofit2.Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                if (response.isSuccessful && !response.body()?.isEmpty()!!) {

                    val users: List<User> = response.body()!!

                } else {

                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
            }

        })
    }

    override fun getActiveUser() {

    }
}