package com.deadely.piegallery.di.module;

import android.app.Application;

import dagger.Module;

@Module
public class AppModule {
    public Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    public Application getApplication() {
        return application;
    }
}
