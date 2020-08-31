package com.example.fb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fb.model.Group
import com.example.fb.model.User

@Database(
    entities = [UserEntity::class, GroupEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LessonsTypeConverter::class, StatTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun groupDao(): GroupDao

    companion object {
        const val DATABASE_NAME = "itlingua"
    }
}
