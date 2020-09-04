package com.deadely.itl_en.database.dao

import androidx.room.*
import com.deadely.itl_en.database.entities.GroupEntity
import com.deadely.itl_en.database.entities.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserList(users: List<UserEntity>)

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE user_id LIKE :id LIMIT 1")
    suspend fun getUserById(id: String): UserEntity

    @Query("SELECT * FROM user_table WHERE active LIKE :active LIMIT 1")
    suspend fun getActiveUser(active: Boolean): UserEntity?

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM user_table WHERE email LIKE :email AND password LIKE :pass")
    suspend fun getByEmailAndPass(email: String, pass: String): UserEntity
}

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGroup(group: GroupEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addList(list: List<GroupEntity>)

    @Update
    suspend fun updateGroup(group: GroupEntity)

    @Delete
    suspend fun deleteGroup(group: GroupEntity)

    @Query("DELETE FROM group_table")
    suspend fun deleteAllGroup()

    @Query("SELECT * FROM group_table")
    suspend fun getAllGroup(): List<GroupEntity>

    @Query("SELECT * FROM group_table WHERE group_id LIKE :id LIMIT 1")
    suspend fun getGroupById(id: String): GroupEntity
}
