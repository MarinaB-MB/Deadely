package com.deadely.itl_en.di.module

import com.deadely.itl_en.App.Companion.instance
import com.deadely.itl_en.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun providedBInstance(): AppDatabase {
        return instance.db
    }
}