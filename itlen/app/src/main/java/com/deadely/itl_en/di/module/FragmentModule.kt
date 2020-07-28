package com.deadely.itl_en.di.module

import androidx.fragment.app.Fragment
import dagger.Module

@Module
class FragmentModule {
    private var fragment: Fragment? = null

    fun FragmentModule(fragment: Fragment?) {
        this.fragment = fragment
    }

    fun getFragment(): Fragment? {
        return fragment
    }
}