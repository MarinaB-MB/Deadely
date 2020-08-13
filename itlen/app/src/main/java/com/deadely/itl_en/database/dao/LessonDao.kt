package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.dataclasses.Lesson

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLesson(lesson: Lesson)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<Lesson>)

    @Update
    fun updateLesson(lesson: Lesson)

    @Delete
    fun deleteLesson(lesson: Lesson)

    @Query("DELETE FROM lessons_table")
    fun deleteAllLessons()

    @Query("SELECT * FROM lessons_table")
    fun getAllLessons(): MutableList<Lesson>

}
