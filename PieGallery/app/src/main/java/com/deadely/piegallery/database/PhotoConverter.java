package com.deadely.piegallery.database;

import androidx.room.TypeConverter;

import com.deadely.piegallery.dataclasses.Photo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class PhotoConverter implements Serializable {

    @TypeConverter
    public String fromPhotoList(List<Photo> photoList) {
        if (photoList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Photo>>() {
        }.getType();
        String json = gson.toJson(photoList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public List<Photo> toPhotoList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Photo>>() {
        }.getType();
        List<Photo> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }

}