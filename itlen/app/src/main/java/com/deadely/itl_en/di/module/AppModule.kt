package com.deadely.itl_en.di.module

import android.app.Application
import dagger.Module

@Module
class AppModule {
    var application: Application? = null

    fun AppModule(application: Application?) {
        this.application = application
    }

    fun getApp(): Application? {
        return application
    }
}