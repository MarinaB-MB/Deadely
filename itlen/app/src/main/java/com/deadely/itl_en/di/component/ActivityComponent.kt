package com.deadely.itl_en.di.component

import com.deadely.itl_en.di.module.ActivityModule
import com.deadely.itl_en.di.module.DatabaseModule
import com.deadely.itl_en.di.module.NetModule
import com.deadely.itl_en.di.module.PresenterModule
import com.deadely.itl_en.di.scope.PerFragment
import com.deadely.itl_en.ui.auth.view.AuthActivity
import com.deadely.itl_en.ui.lessonlist.view.LessonsListActivity
import com.deadely.itl_en.ui.main.view.MainActivity
import com.deadely.itl_en.ui.reg.view.RegActivity
import com.deadely.itl_en.ui.splash.view.SplashScreenActivity
import dagger.Subcomponent

@PerFragment
@Subcomponent(modules = [ActivityModule::class, PresenterModule::class, NetModule::class, DatabaseModule::class])
interface ActivityComponent {
    fun inject(activity: SplashScreenActivity?)
    fun inject(activity: AuthActivity?)
    fun inject(activity: RegActivity?)
    fun inject(activity: MainActivity?)
    fun inject(activity: LessonsListActivity?)
}