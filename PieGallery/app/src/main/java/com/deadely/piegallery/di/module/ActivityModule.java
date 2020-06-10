package com.deadely.piegallery.di.module;

import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;

@Module
public class ActivityModule {
    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }
}
