package com.deadely.itl_en

import android.app.Application
import androidx.room.Room
import com.deadely.itl_en.database.AppDatabase
import com.deadely.itl_en.di.component.AppComponent
import com.deadely.itl_en.di.component.DaggerAppComponent
import com.deadely.itl_en.di.module.AppModule

class App : Application() {
    lateinit var component: AppComponent
    lateinit var db: AppDatabase
    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        db = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "itl")
                .allowMainThreadQueries()
                .build()
    }

    fun getAppComponent(): AppComponent {
        return component
    }

    fun getAppDatabase(): AppDatabase? {

        return db
    }

    companion object {
        lateinit var instance: App private set
    }
}