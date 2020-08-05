package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.dataclasses.Stat

@Dao
interface StatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStat(stat: Stat)

    @Update
    fun updateStat(stat: Stat)

    @Delete
    fun deleteStat(stat: Stat)

    @Query("DELETE FROM stat_table")
    fun deleteAllStats()

    @Query("SELECT * FROM stat_table WHERE stat_user_id LIKE :id LIMIT 1")
    fun getStatByUserId(id: String): Stat


    @Query("SELECT * FROM stat_table WHERE stat_id LIKE :id LIMIT 1")
    fun getStatById(id: String): Stat

    @Query("SELECT * FROM stat_table")
    fun getAllStats(): List<Stat>
}
