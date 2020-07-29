package com.deadely.itl_en.di.module;

import com.deadely.itl_en.App;

import dagger.Module;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    public App getApp() {
        return app;
    }
}
