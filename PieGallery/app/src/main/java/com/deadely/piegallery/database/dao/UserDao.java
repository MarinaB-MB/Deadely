package com.deadely.piegallery.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadely.piegallery.dataclasses.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table")
    List<User> getAllUsers();

    @Query("SELECT * FROM user_table WHERE user_id  LIKE :id")
    User getById(long id);

    @Query("DELETE FROM user_table")
    public void deleteAllUsers();

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

}
