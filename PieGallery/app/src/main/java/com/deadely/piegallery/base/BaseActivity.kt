package com.deadely.piegallery.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.deadely.piegallery.R
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity(layout: Int) : MvpAppCompatActivity(layout), BaseView {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = AppNavigator(this, R.id.fragmentСontainer)

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getExtras()
        setListeners()
        initView()
    }

    abstract fun setListeners()
    abstract fun initView()
    abstract fun getExtras()
    override fun onBackPressed() {
        val fm = supportFragmentManager
        var fragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
        val childFm = fragment?.childFragmentManager
        var childFragment: Fragment? = null
        childFm?.let {
            for (f in childFm.fragments) {
                if (f.isVisible) {
                    childFragment = f
                    break
                }
            }
        }
        if (childFragment != null && (childFragment is BackButtonPressed)) {
            childFm?.let {
                if (it.backStackEntryCount > 0) {
                    (childFragment as BackButtonPressed).onBackButtonPressed()
                    return
                } else {
                    (childFragment as ExitListener).exitPressed()
                    return
                }
            }
        } else {
            if (fragment != null && fragment is BackButtonPressed) {
                (fragment as BackButtonPressed).onBackButtonPressed()
                return
            } else {
                router.exit()
                return
            }
        }
    }

    interface BackButtonPressed {
        fun onBackButtonPressed()
    }

    interface ExitListener {
        fun exitPressed()
    }
}
