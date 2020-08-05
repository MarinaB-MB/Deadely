package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.dataclasses.Words

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWord(words: Words)

    @Update
    fun updateWord(words: Words)

    @Delete
    fun deleteWord(words: Words)

    @Query("DELETE FROM words_table")
    fun deleteAllWords()

    @Query("SELECT * FROM words_table WHERE words_id LIKE :id LIMIT 1")
    fun getWordById(id: String): Words

    @Query("SELECT * FROM words_table WHERE words_lesson_id LIKE :id")
    fun getWordByLessonId(id: String): List<Words>

    @Query("SELECT * FROM words_table")
    fun getAllWords(): List<Words>
}
