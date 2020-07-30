package com.deadely.itl_en

import android.app.Application
import com.deadely.itl_en.di.component.AppComponent
import com.deadely.itl_en.di.component.DaggerAppComponent
import com.deadely.itl_en.di.module.AppModule

class App : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getAppComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: App private set
    }
}