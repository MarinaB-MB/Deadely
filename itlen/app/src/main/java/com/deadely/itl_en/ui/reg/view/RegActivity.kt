package com.deadely.itl_en.ui.reg.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
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
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initView() {
        title = getString(R.string.reg)

        btnReg.setOnClickListener(View.OnClickListener {
            if (checkFields())
                presenter.createNewUser(name, pass, email, active)
        })
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
            if (etPassOne.text.toString() != etPassTwo.text.toString()) {
                showMessage(FieldConverter().getString(R.string.pass_is_not_compare))
                return false
            } else {
                if (etPassOne.text.toString().length < 6) {
                    showMessage(FieldConverter().getString(R.string.short_pass_length))
                    return false
                } else {
                    email = etEmail.text.toString()
                    name = etName.text.toString()
                    pass = etPassOne.text.toString()
                    return true
                }

            }
        }
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}