package com.deadely.itl_en.di.module

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val fragment: Fragment) {
    @Provides
    fun provideFragment(): Fragment {
        return fragment
    }
}