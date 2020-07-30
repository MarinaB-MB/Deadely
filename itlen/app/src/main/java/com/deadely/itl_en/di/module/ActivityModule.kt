package com.deadely.itl_en.di.module

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val appCompatActivity: AppCompatActivity) {
    @Provides
    fun provideActivity(): AppCompatActivity {
        return appCompatActivity
    }
}