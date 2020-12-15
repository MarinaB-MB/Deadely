package com.deadely.piegallery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.deadely.piegallery.utils.Constants.PIE_GALLERY

@Database(
    entities = [PhotoEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PhotoEntityTypeConverter::class, UserEntityTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = PIE_GALLERY
    }

    abstract fun photoDao(): PhotoDao
}
