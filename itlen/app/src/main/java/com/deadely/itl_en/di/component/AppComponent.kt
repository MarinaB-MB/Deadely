package com.deadely.itl_en.di.component

import com.deadely.itl_en.di.module.ActivityModule
import com.deadely.itl_en.di.module.AppModule
import com.deadely.itl_en.di.module.FragmentModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun activityComponent(activityModule: ActivityModule?): ActivityComponent?
    fun fragmentComponent(fragmentModuke: FragmentModule?): FragmentComponent?
}