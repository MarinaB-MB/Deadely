package com.deadely.itl_en.ui.reg.presenter

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ud = db.userDao()
    }

    override fun getUsersList(): Boolean {
        return ud.getAllUsers().isNotEmpty()
    }

    override fun createNewUser(name: String, password: String, email: String, active: Boolean) {
        clearActiveUser()

        val post = PostUser(email, password, name, true)
        val call = apiInterface.createUser(post)
        call.enqueue(object : retrofit2.Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    if (userResponse != null) {
                        ud.addUser(userResponse)
                        getMvpView()?.openMainScreen()
                    }
                } else {
                    getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error));
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                getMvpView()?.showMessage(t.message.toString())
            }
        })
    }

    override fun clearActiveUser() {
        if (ud.getActiveUser(true) != null) {
            val id = ud.getActiveUser(true)._id
            val email = ud.getActiveUser(true).email
            val put = PostUser(email.toString(), false)

            val call = apiInterface.updateUser(id, put)
            call.enqueue(object : retrofit2.Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (!response.isSuccessful) {
                        getMvpView()?.showMessage(FieldConverter().getString(R.string.unexpected_error));
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    getMvpView()?.showMessage(t.message.toString())
                }
            })
        }
    }


}