package com.deadely.itl_en.ui.auth.presenter

import com.deadely.itl_en.base.BasePresenter
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.ui.auth.IAuthContract
import javax.inject.Inject

class AuthPresenter @Inject constructor(private var db: AppDatabase) : BasePresenter<IAuthContract.View>(), IAuthContract.Presenter {
    private lateinit var ud: UserDao

    override fun compareUserDate(email: String, pass: String): Boolean {
        ud = db.userDao()
        val user = ud.getByEmailAndPass(email, pass)
        return user != null
    }


}