package com.deadely.itl_en;

import android.app.Application;

import com.deadely.itl_en.di.component.AppComponent;
import com.deadely.itl_en.di.component.DaggerAppComponent;
import com.deadely.itl_en.di.module.AppModule;

public class App extends Application {
    private AppComponent component;
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public AppComponent getComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return component;
    }

    public static App getInstance() {
        return instance;
    }
}
