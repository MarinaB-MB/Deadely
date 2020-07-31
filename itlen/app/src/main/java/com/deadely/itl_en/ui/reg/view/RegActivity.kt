package com.deadely.itl_en.ui.reg.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import butterknife.OnClick
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.reg.IRegContract
import javax.inject.Inject

class RegActivity : BaseActivity(), IRegContract.View {
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