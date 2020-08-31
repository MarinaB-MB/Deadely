package com.deadely.itl_en.ui.auth.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.deadely.itl_en.R
import com.deadely.itl_en.model.User
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.view.RegActivity
import com.deadely.itl_en.utils.DataState
import com.deadely.itl_en.utils.Event
import com.deadely.itl_en.utils.FieldConverter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_auth.*

@AndroidEntryPoint
class AuthActivity : AppCompatActivity(R.layout.activity_auth) {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    companion object {
        const val TAG: String = "AuthActivity.TAG"
    }

    private fun initView() {
        supportActionBar?.hide()
        tvCreateAcc.setOnClickListener { openRegScreen() }
        btnAuth.setOnClickListener {
            if (checkFieldsWithDB()) getUser()
        }
    }

    private fun getUser() {
        viewModel.email = etEmail.text.toString()
        viewModel.setEvent(Event.getUserByEmail)
        viewModel.mUsers.observe(this, Observer {
            when (it) {
                is DataState.Loading -> {
                    Log.e(TAG, "loading")
                }
                is DataState.Error -> {
                    Log.e(TAG, "error")
                    Log.e(TAG, it.exception.localizedMessage)
                    showMessage(it.exception.localizedMessage)
                }
                is DataState.Success -> {
                    Log.e(TAG, "success")
                    Log.e(TAG, "${it.data}")
                    if (it.data.isNotEmpty() && it.data != null) {
                        viewModel.user = it.data.first()
                        compareUser(viewModel.user, etEmail.text.toString(), etPassOne.text.toString())
                    } else {
                        showMessage("not found")
                    }
                }
            }
        })
    }

    private fun compareUser(user: User, email: String, password: String) {
        if (user.email == email && user.password == password) {
            viewModel.setEvent(Event.addUser)
            openMainScreen()
        } else {
            Toast.makeText(this, FieldConverter().getString(R.string.data_different_try_again), Toast.LENGTH_SHORT).show()
        }
    }


    private fun checkFieldsWithDB(): Boolean {
        return if (etEmail.text.toString() == "" || etPassOne.text.toString() == "") {
            showMessage(FieldConverter().getString(R.string.empty_fields))
            false
        } else {
            if (etPassOne.text.toString().length < 6) {
                showMessage(FieldConverter().getString(R.string.short_pass_length))
                false
            } else {
                true
            }
        }
    }

    private fun openMainScreen() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    private fun openRegScreen() {
        startActivity(Intent(applicationContext, RegActivity::class.java))
        finish()
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}