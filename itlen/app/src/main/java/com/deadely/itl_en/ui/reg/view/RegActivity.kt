package com.deadely.itl_en.ui.reg.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.IRegContract
import com.deadely.itl_en.utils.FieldConverter
import kotlinx.android.synthetic.main.activity_reg.*
import javax.inject.Inject

class RegActivity : BaseActivity(), IRegContract.View {
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var name: String
    private var active: Boolean = true

    @Inject
    lateinit var presenter: IRegContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initView() {
        title = getString(R.string.reg)

        tvLogIn.setOnClickListener {
            if (presenter.getUsersList()) openAuthScreen()
            else showMessage(getString(R.string.create_user_before_auth))
        }

        btnReg.setOnClickListener {
            if (checkFields()) {
            }
//                createDataObject()
//                presenter.createNewUser(name, pass, email, active)
        }
    }

    @SuppressLint("HardwareIds")
    private fun createDataObject() {
        val deviceId = Settings.Secure.getString(baseContext.contentResolver, Settings.Secure.ANDROID_ID)
        presenter.createNewData(deviceId)
    }


    override fun openMainScreen() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    override fun checkFields(): Boolean {
        if (etName.text.toString() == "" || etEmail.text.toString() == "" || etPassOne.text.toString() == "" || etPassTwo.text.toString() == "") {
            showMessage(FieldConverter().getString(R.string.empty_fields))
            return false
        } else {
            return if (etPassOne.text.toString() != etPassTwo.text.toString()) {
                showMessage(FieldConverter().getString(R.string.pass_is_not_compare))
                false
            } else {
                if (etPassOne.text.toString().length < 6) {
                    showMessage(FieldConverter().getString(R.string.short_pass_length))
                    false
                } else {
                    email = etEmail.text.toString()
                    name = etName.text.toString()
                    pass = etPassOne.text.toString()
                    true
                }

            }
        }
    }

    override fun openAuthScreen() {
        startActivity(Intent(applicationContext, AuthActivity::class.java))
        finish()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}