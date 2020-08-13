package com.deadely.itl_en.ui.main.view

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.deadely.itl_en.R
import com.deadely.itl_en.base.BaseActivity
import com.deadely.itl_en.di.component.ActivityComponent
import com.deadely.itl_en.ui.main.IMainContract
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), IMainContract.View {
    @Inject
    lateinit var presenter: IMainContract.Presenter

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate(savedInstanceState)
        initView()
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    private fun initView() {
        presenter.attachView(this)
        navController = Navigation.findNavController(this, R.id.navFragment)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            if (!item.isChecked) navController.navigate(item.itemId)
            true
        }

        //back press
    }

    override fun showMessage(msg: String) {

    }
}