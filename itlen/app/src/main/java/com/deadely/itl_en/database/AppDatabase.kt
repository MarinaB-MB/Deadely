package com.deadely.itl_en.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deadely.itl_en.database.converters.*
import com.deadely.itl_en.database.dao.GroupDao
import com.deadely.itl_en.database.dao.UserDao
import com.deadely.itl_en.dataclasses.*

@Database(
        entities = [User::class, Data::class, Stat::class, Group::class, Lesson::class, Words::class],
        version = 1,
        exportSchema = false)
@TypeConverters(DateTypeConverter::class, WordTypeConverter::class, StringTypeConverter::class, LessonsTypeConverter::class, UserTypeConverter::class, StatTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun groupDao(): GroupDao
}