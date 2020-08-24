package com.deadely.itl_en.ui.reg.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
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
        presenter.attachView(this)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initView() {
        title = getString(R.string.reg)

        tvLogIn.setOnClickListener {
            openAuthScreen()
        }

        btnReg.setOnClickListener {
            if (checkFields()) {
                presenter.createNewUser(name, pass, email, active)
            }
        }
    }

    override fun openMainScreen() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    override fun checkFields(): Boolean {
        return if (etName.text.toString() == "" || etEmail.text.toString() == "" || etPassOne.text.toString() == "") {
            showMessage(FieldConverter().getString(R.string.empty_fields))
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

    override fun openAuthScreen() {
        startActivity(Intent(applicationContext, AuthActivity::class.java))
        finish()
    }

    override fun startLoading() {
        super.startLoading()
        rlContent.visibility = GONE
        pvLoad.visibility = VISIBLE
    }

    override fun completeLoading() {
        super.completeLoading()
        rlContent.visibility = VISIBLE
        pvLoad.visibility = GONE
    }

    override fun errorLoading() {
        super.errorLoading()
        rlContent.visibility = GONE
        pvLoad.visibility = GONE
        rlErrorContainer.visibility = VISIBLE
    }

    override fun showEmailError(msg: String) {
        tvEmailError.visibility = View.VISIBLE
        tvEmailError.text = msg
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}