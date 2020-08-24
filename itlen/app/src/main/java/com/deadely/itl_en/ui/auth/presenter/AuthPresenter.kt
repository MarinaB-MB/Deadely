package com.deadely.itl_en.ui.auth.presenter

import com.deadely.itl_en.R
import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.User
import com.deadely.itl_en.network.IRestDBService
import com.deadely.itl_en.ui.auth.IAuthContract
import com.deadely.itl_en.utils.FieldConverter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class AuthPresenter @Inject constructor(private var db: AppDatabase, val apiInterface: IRestDBService) : BasePresenter<IAuthContract.View>(), IAuthContract.Presenter {
    private lateinit var ud: UserDao

    override fun compareUserDate(email: String, pass: String): Boolean {
        ud = db.userDao()
        val user = ud.getByEmailAndPass(email, pass)
        return user != null
    }


    private fun convertToString(email: String): String {
        return "{\"email\":\"$email\"}"
    }

    override fun findUser(email: String) {
        getMvpView()?.startLoading()
        val call = apiInterface.getUserByEmail(convertToString(email))
        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful && response.body() != null) {
                    val user = response.body()
                    if (user != null) {
                        ud.addUser(user)
                        getMvpView()?.openMainScreen()
                    }
                    getMvpView()?.completeLoading()
                } else {
                    getMvpView()?.completeLoading()
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                getMvpView()?.errorLoading()
                getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error))
            }
        })
    }

}