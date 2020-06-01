package com.deadely.piegallery.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadely.piegallery.dataclasses.Urls;

import java.util.List;

@Dao
public interface UrlsDao {


    @Query("SELECT * FROM urls_table")
    List<Urls> getAllUrls();

    @Query("SELECT * FROM urls_table WHERE urls_raw  LIKE :raw")
    Urls getByRaw(String raw);

    @Query("DELETE FROM urls_table")
    public void deleteAllUrls();

    @Insert
    void insert(Urls urls);

    @Update
    void update(Urls urls);

    @Delete
    void delete(Urls urls);
}
