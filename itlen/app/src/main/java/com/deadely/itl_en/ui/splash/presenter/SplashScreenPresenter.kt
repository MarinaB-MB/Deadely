package com.deadely.itl_en.ui.splash.presenter

import android.util.Log
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.Data
import com.deadely.itl_en.dataclasses.DataRequestBody
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.splash.ISplashScreenContract
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor(private var apiInterface: IRestDBService, private var db: AppDatabase) : BasePresenter<ISplashScreenContract.View>(), ISplashScreenContract.Presenter {

    private lateinit var ud: UserDao
    private val FIRST_SIGNIN = "firstSignIn"


    override fun getUsers(deviceId: String, isFirstSignIn: Boolean) {
        if (isFirstSignIn) {
            val call = apiInterface.newData(DataRequestBody(deviceId, emptyList()))
            call.enqueue(object : retrofit2.Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    if (response.isSuccessful) {
                        db.dataDao().addData(response.body()!!)
                        getMvpView()?.changeState()
                        getMvpView()?.openRegScreen()
//change firstSignIn
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.e("TAG", "onFailure: create new data")
                }
            })
        } else {
            val id = db.dataDao().getData()._id
            val call = apiInterface.getDataById(id)
            call.enqueue(object : retrofit2.Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    if (response.isSuccessful) {
                        val data: Data = response.body()!!
                        db.dataDao().addData(data)
                        db.userDao().addUserList(data.users)
                        if (db.userDao().getAllUsers() != null && db.userDao().getAllUsers().isNotEmpty())
                            getActiveUser()
                        else getMvpView()?.openRegScreen()
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.e("TAG", "onFailure: get data")
                }
            })
        }


//        ud = db.userDao()
//        val call = apiInterface.getUsers()
//        call.enqueue(object : retrofit2.Callback<MutableList<User>> {
//            override fun onResponse(call: Call<MutableList<User>>, response: Response<MutableList<User>>) {
//                if (response.isSuccessful) {
//                    if (response.body()?.size == 0) {
//                        getMvpView()?.openRegScreen()
//                    } else {
//                        val users: List<User> = response.body()!!
//                        for (user in users) {
//                            ud.addUser(user)
//                        }
//                        getActiveUser()
//                    }
//
//                } else {
//                    getMvpView()?.retry()
//                }
//            }
//
//            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
//                getMvpView()?.retry()
//            }
//        })
    }

    override fun getActiveUser() {
        ud = db.userDao()
        val user = ud.getActiveUser(true)
        if (user != null) {
            getMvpView()?.openMainScreen()
        } else {
            getMvpView()?.openAuthScreen()
        }
    }

    override fun openConnectionDialog() {
        getMvpView()?.showConnectionDialog()
    }
}