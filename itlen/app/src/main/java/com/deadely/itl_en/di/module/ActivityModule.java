package com.deadely.itl_en.di.module;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;

@Module
public class ActivityModule {
    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }
}
