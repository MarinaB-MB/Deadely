package com.deadely.piegallery.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.ui.main.MainView
import com.deadely.piegallery.ui.main.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main), MainView, BaseActivity.BackButtonPressed, BaseActivity.ExitListener, SelectedItemlistener {
    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    override fun initView() {
        presenter.openMainPhotoListScreen()
        bottomNav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            if (!menuItem.isChecked) {
                when (menuItem.itemId) {
                    R.id.nav_favorites -> presenter.openFavoriteListScreen()
                    R.id.nav_photos -> presenter.openMainPhotoListScreen()
                    R.id.nav_info -> presenter.openInfoScreen()
                }
            }
            true
        }
    }

    override fun setListeners() {}

    override fun onBackButtonPressed() {
        presenter.exit()
    }

    override fun exitPressed() {
        presenter.exit()
    }

    override fun onItemBackPressed() {
        bottomNav.menu.getItem(0).isChecked = true
    }

    override fun getExtras() {
    }
}

interface SelectedItemlistener {
    fun onItemBackPressed()
}
