package com.deadely.piegallery;

import android.app.Application;

import androidx.room.Room;

import com.deadely.piegallery.database.AppDBHelper;

public class App extends Application {
    private static App instance;
    private AppDBHelper db;

    public AppDBHelper getDatabaseInstance() {
        return db;
    }

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

}
