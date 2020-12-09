package com.deadely.piegallery.ui.main.view

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.deadely.piegallery.R
import com.deadely.piegallery.base.BaseActivity
import com.deadely.piegallery.ui.favorites.view.FavoritesFragment
import com.deadely.piegallery.ui.info.view.InfoFragment
import com.deadely.piegallery.ui.main.MainView
import com.deadely.piegallery.ui.main.presenter.MainPresenter
import com.deadely.piegallery.ui.photos.view.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main), MainView {
    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        return fragment?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentСontainer, fragment)
                .commit()
            true
        } ?: false
    }

    override fun initView() {
        loadFragment(PhotosFragment())
        bottomNav.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.nav_favorites -> loadFragment(FavoritesFragment())
                R.id.nav_photos -> loadFragment(PhotosFragment())
                R.id.nav_info -> loadFragment(InfoFragment())
            }
            true
        }
    }

    override fun setListeners() {}
}
