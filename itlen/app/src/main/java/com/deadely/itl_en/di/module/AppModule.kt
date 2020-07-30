package com.deadely.itl_en.di.module

import android.app.Application
import com.deadely.itl_en.App
import com.deadely.itl_en.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {
    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return app
    }


}