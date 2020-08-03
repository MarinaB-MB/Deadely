package com.deadely.itl_en.ui.auth.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.auth.IAuthContract
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.view.RegActivity
import com.deadely.itl_en.utils.FieldConverter
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_reg.etEmail
import kotlinx.android.synthetic.main.activity_reg.etPassOne
import javax.inject.Inject

class AuthActivity : BaseActivity(), IAuthContract.View {
    @Inject
    lateinit var presenter: IAuthContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    companion object {
        const val TAG: String = "AuthActivity.TAG"
    }

    private fun initView() {
        title = getString(R.string.auth)

        tvCreateAcc.setOnClickListener { openRegScreen() }

        btnAuth.setOnClickListener {
            if (checkFieldsWithDB()) openMainScreen()
        }
    }


    override fun openMainScreen() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun checkFieldsWithDB(): Boolean {
        return if (etEmail.text.toString() == "" || etPassOne.text.toString() == "") {
            showMessage(FieldConverter().getString(R.string.empty_fields))
            false
        } else {
            if (etPassOne.text.toString().length < 6) {
                showMessage(FieldConverter().getString(R.string.short_pass_length))
                false
            } else {
                presenter.compareUserDate(etEmail.text.toString(), etPassOne.text.toString())
            }
        }
    }

    override fun openRegScreen() {
        startActivity(Intent(applicationContext, RegActivity::class.java))
        finish()
    }

}