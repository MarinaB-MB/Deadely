package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.dataclasses.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE user_id LIKE :id LIMIT 1")
    fun getUserById(id: String): User

    @Query("SELECT * FROM user_table WHERE active LIKE :active LIMIT 1")
    fun getActiveUser(active: Boolean): User


    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user_table WHERE email LIKE :email AND password LIKE :pass")
    fun getByEmailAndPass(email: String, pass: String): User


}
