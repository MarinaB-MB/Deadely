package com.deadely.piegallery.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadely.piegallery.dataclasses.Photo;

import java.util.List;

@Dao
public interface PhotoDao {

    @Query("SELECT * FROM photo_table")
    List<Photo> getAllPhotos();

    @Query("SELECT * FROM photo_table WHERE photo_id  LIKE :id")
    Photo getById(String id);

    @Query("DELETE FROM photo_table")
    public void deleteAllPhotos();

    @Query("DELETE FROM photo_table")
    public void deleteAll();

    @Insert
    void insert(Photo photo);

    @Update
    void update(Photo photo);

    @Delete
    void delete(Photo photo);
}
