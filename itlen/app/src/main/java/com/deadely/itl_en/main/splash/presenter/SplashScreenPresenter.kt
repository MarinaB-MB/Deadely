package com.deadely.itl_en.main.splash.presenter

import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.main.splash.ISplashScreenContract
import com.deadely.itl_en.network.RestDBService
import retrofit2.Call
import retrofit2.Response

class SplashScreenPresenter : ISplashScreenContract.Presenter {
    override fun getUsers() {
        val call = RestDBService().apIinterface()?.getUsers()
        call?.enqueue(object : retrofit2.Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                if (response.isSuccessful && !response.body()?.isEmpty()!!) {

                } else {

                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
//                getMvpView().showError();
            }

        })
    }

    override fun getActiveUser() {

    }
}