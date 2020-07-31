package com.deadely.itl_en.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deadely.itl_en.database.converters.DateTypeConverter
import com.deadely.itl_en.database.converters.LessonsTypeConverter
import com.deadely.itl_en.database.converters.StringTypeConverter
import com.deadely.itl_en.database.converters.WordTypeConverter
import com.deadely.itl_en.database.dao.*
import com.deadely.itl_en.dataclasses.*

@Database(entities = [User::class, Stat::class, Group::class, Lesson::class, Words::class], version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter::class, WordTypeConverter::class, StringTypeConverter::class, LessonsTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun statDao(): StatDao
    abstract fun groupDao(): GroupDao
    abstract fun lessonDao(): LessonDao
    abstract fun wordDao(): WordDao

//    companion object {
//        var instance: AppDatabase? = null
//
//        fun getAppDatabase(): AppDatabase? {
//            if (instance == null) {
//                instance = Room.databaseBuilder(App.instance.applicationContext,
//                        AppDatabase::class.java, "itl")
//                        .allowMainThreadQueries()
//                        .build()
//            }
//            return instance
//        }
//
//        fun destroyInstance() {
//            instance = null
//        }
//    }

}