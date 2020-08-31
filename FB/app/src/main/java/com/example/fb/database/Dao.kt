package com.example.fb.database

import androidx.room.*
import com.example.fb.model.Group
import com.example.fb.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserList(users: List<UserEntity>)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE user_id LIKE :id LIMIT 1")
    fun getUserById(id: String): UserEntity

    @Query("SELECT * FROM user_table WHERE active LIKE :active LIMIT 1")
    fun getActiveUser(active: Boolean): UserEntity


    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user_table WHERE email LIKE :email AND password LIKE :pass")
    fun getByEmailAndPass(email: String, pass: String): UserEntity

}

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGroup(group: GroupEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addList(list: List<GroupEntity>)

    @Update
    fun updateGroup(group: GroupEntity)

    @Delete
    fun deleteGroup(group: GroupEntity)

    @Query("DELETE FROM group_table")
    fun deleteAllGroup()

    @Query("SELECT * FROM group_table")
    fun getAllGroup(): List<GroupEntity>

    @Query("SELECT * FROM group_table WHERE group_id LIKE :id LIMIT 1")
    fun getGroupById(id: String): GroupEntity

}
