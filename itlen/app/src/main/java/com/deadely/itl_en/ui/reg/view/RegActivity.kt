package com.deadely.itl_en.ui.reg.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.R
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.utils.FieldConverter
import kotlinx.android.synthetic.main.activity_reg.*

class RegActivity : AppCompatActivity(R.layout.activity_reg) {
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var name: String
    private var active: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        supportActionBar?.hide()

        tvLogIn.setOnClickListener {
            openAuthScreen()
        }

        btnReg.setOnClickListener {
            if (checkFields()) {

            }
        }
    }

    fun openMainScreen() {
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    fun checkFields(): Boolean {
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

    fun openAuthScreen() {
        startActivity(Intent(applicationContext, AuthActivity::class.java))
        finish()
    }

    fun showEmailError(msg: String) {
        tvEmailError.visibility = View.VISIBLE
        tvEmailError.text = msg
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}