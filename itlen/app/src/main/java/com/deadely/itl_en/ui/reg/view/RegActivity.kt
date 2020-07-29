package com.deadely.itl_en.ui.reg.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick
import com.deadely.itl_en.R
import com.deadely.itl_en.ui.reg.IRegContract

class RegActivity : AppCompatActivity(), IRegContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initView()
    }

    private fun initView() {
        title = getString(R.string.reg)
    }

    @OnClick(R.id.btnReg)
    public fun onClick(view: View) {

    }

    override fun openMainScreen() {

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}