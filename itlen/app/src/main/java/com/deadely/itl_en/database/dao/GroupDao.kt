package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.dataclasses.Group

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGroup(group: Group)

    @Update
    fun updateGroup(group: Group)

    @Delete
    fun deleteGroup(group: Group)

    @Query("DELETE FROM group_table")
    fun deleteAllGroup()

    @Query("SELECT * FROM group_table")
    fun getAllGroup(): MutableList<Group>

}
