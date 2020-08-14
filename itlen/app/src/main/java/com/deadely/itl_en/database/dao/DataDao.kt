package com.deadely.itl_en.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deadely.itl_en.dataclasses.Data

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addData(data: Data)

    @Query("SELECT * from data")
    fun getData(): Data
}
