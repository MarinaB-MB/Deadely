package com.deadely.itl_en.ui.auth.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.auth.IAuthContract
import kotlinx.android.synthetic.main.activity_reg.*
import javax.inject.Inject

class AuthActivity : BaseActivity(), IAuthContract.View {
    @Inject
    private lateinit var presenter: IAuthContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        TODO("Not yet implemented")
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