package com.deadely.piegallery.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PhotoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "pie_gallery"
    }
    abstract fun photoDao(): PhotoDao
}
