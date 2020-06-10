package com.deadely.piegallery;

import android.app.Application;

import androidx.room.Room;

import com.deadely.piegallery.database.AppDBHelper;
import com.deadely.piegallery.di.component.AppComponent;
import com.deadely.piegallery.di.component.DaggerAppComponent;
import com.deadely.piegallery.di.module.AppModule;

public class App extends Application {
    private static App instance;
    private AppDBHelper db;

    public AppDBHelper getDatabaseInstance() {
        return db;
    }

    private AppComponent component;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        db = Room.databaseBuilder(getApplicationContext(), AppDBHelper.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public AppComponent getComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return component;
    }
}
