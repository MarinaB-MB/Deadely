package com.deadely.piegallery.database

import androidx.room.*

@Dao
interface PhotoDao {
    @Query("SELECT * FROM favorite_table")
    fun getAllFavorites(): List<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoritePhoto(photoEntity: PhotoEntity)

    @Delete
    fun deleteFavoritePhoto(photoEntity: PhotoEntity)
}
