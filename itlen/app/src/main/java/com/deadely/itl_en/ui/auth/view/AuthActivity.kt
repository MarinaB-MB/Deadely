package com.deadely.itl_en.ui.auth.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.OnClick
import com.deadely.itl_en.R
import com.deadely.itl_en.ui.auth.IAuthContract
import kotlinx.android.synthetic.main.activity_reg.*

class AuthActivity : AppCompatActivity(), IAuthContract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initView()
    }

    companion object {
        const val TAG: String = "AuthActivity.TAG"
    }

    private fun initView() {
        title = getString(R.string.auth)
    }

    @OnClick(R.id.btnReg)
    fun onClick(view: View) {
        Log.e(TAG, "onClick: Clicked")
    }

    override fun openMainScreen() {

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun checkFields(): Boolean {
        if (!etName.equals("") && !etEmail.equals("")) {
//            getactiveUser()
            return true
        } else {
            return false
        }
    }

    override fun authUser() {

    }

}