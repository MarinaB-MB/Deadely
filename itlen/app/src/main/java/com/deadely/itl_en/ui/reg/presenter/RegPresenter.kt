package com.deadely.itl_en.ui.reg.presenter

import android.util.Log
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.PostUser
import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.reg.IRegContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RegPresenter @Inject constructor(private var db: AppDatabase, private var apiInterface: IRestDBService) : BasePresenter<IRegContract.View>(), IRegContract.Presenter {

    private lateinit var ud: UserDao
    override fun createNewUser(name: String, email: String, password: String, active: Boolean) {

        val body = PostUser(email, password, name, true)
        val call = apiInterface.createUser(body)
        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    Log.e("TAG", "onResponse: isSuccessful. user: ${userResponse?._id}  user: ${userResponse?.email} ")
                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error));
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString())
            }
        })
    }

    override fun setActiveUser() {

    }


}