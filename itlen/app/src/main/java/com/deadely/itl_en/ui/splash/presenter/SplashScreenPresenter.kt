package com.deadely.itl_en.ui.splash.presenter

import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(private var apiInterface: IRestDBService, private var db: AppDatabase) : BasePresenter<ISplashScreenContract.View>(), ISplashScreenContract.Presenter {

    private lateinit var ud: UserDao

    override fun getUsers() {
        ud = db.userDao()
        val call = apiInterface.getUsers()
        call.enqueue(object : retrofit2.Callback<MutableList<User>> {
            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
                if (response.isSuccessful) {
                    if (response.body()?.size == 0) {
                        getMvpView()?.openRegScreen()
                    } else {
                        val users: List<User> = response.body()!!
                        for (user in users) {
                            ud.addUser(user)
                        }
                        getActiveUser()
                    }

                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error));
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString());
            }
        })
    }

    override fun getActiveUser() {
        val user = ud.getActiveUser(true)
        if (user != null) {
            getMvpView()?.openMainScreen()
        } else {
            getMvpView()?.openAuthScreen()
        }
    }


}