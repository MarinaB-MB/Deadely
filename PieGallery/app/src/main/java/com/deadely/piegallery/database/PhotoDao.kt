package com.deadely.piegallery.database

import androidx.room.*
import io.reactivex.Single

@Dao
interface PhotoDao {
    @Query("SELECT * FROM favorite_table")
    fun getAllFavorites(): Single<List<PhotoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavoritePhoto(photoEntity: PhotoEntity)

    @Delete
    fun deleteFavoritePhoto(photoEntity: PhotoEntity)
}
