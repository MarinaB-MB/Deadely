package com.deadely.itl_en.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deadely.itl_en.database.converters.*
import com.deadely.itl_en.database.dao.*
import com.deadely.itl_en.dataclasses.*

@Database(entities = [User::class, Data::class, Stat::class, Group::class, Lesson::class, Words::class], version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter::class, WordTypeConverter::class, StringTypeConverter::class, LessonsTypeConverter::class, UserTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun statDao(): StatDao
    abstract fun groupDao(): GroupDao
    abstract fun lessonDao(): LessonDao
    abstract fun wordDao(): WordDao
    abstract fun dataDao(): DataDao
}