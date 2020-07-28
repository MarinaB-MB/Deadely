package com.deadely.itl_en.di.module

import androidx.appcompat.app.AppCompatActivity
import dagger.Module

@Module
class ActivityModule {
    private var activity: AppCompatActivity? = null

    fun ActivityModule(activity: AppCompatActivity?) {
        this.activity = activity
    }

    fun getActivity(): AppCompatActivity? {
        return activity
    }
}