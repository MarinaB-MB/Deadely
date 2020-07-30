package com.deadely.itl_en.di.module

import androidx.appcompat.app.AppCompatActivity
import com.deadely.itl_en.database.AppDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val context: AppCompatActivity?) {

    @Provides
    fun provideDBInstance(): AppDatabase? {
        return context?.let { AppDatabase.getAppDatabase(it) }
    }
}