package com.deadely.itl_en.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.deadely.itl_en.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }


    private fun initView() {
        navController = Navigation.findNavController(this, R.id.navFragment)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            if (!item.isChecked) navController.navigate(item.itemId)
            true
        }
    }

    fun showMessage(msg: String) {

    }
}