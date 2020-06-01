package com.deadely.piegallery.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.deadely.piegallery.dataclasses.Favorites;

import java.util.List;

@Dao
public interface FavoritesDao {

    @Query("SELECT * FROM favorites_table")
    List<Favorites> getAllFavorites();

    @Query("SELECT * FROM favorites_table WHERE fav_id  LIKE :id")
    Favorites getById(int id);

    @Query("DELETE FROM favorites_table")
    public void deleteAllFavorites();

    @Query("DELETE FROM favorites_table")
    public void deleteAll();

    @Query("DELETE FROM favorites_table WHERE photo_id LIKE :id")
    public void deleteByPhotoId(String id);

    @Insert
    void insert(Favorites fav);

    @Update
    void update(Favorites fav);

    @Delete
    void delete(Favorites fav);

    @Query("SELECT * FROM favorites_table WHERE photo_id LIKE :id")
    Favorites findByPhotoId(String id);
}
