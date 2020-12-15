package com.deadely.piegallery.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*

class PhotoEntityTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun stringToPhotoEntityList(data: String?): List<PhotoEntity> {
        data?.let {
            val listType = object : TypeToken<List<PhotoEntity>>() {}.type
            return gson.fromJson<List<PhotoEntity>>(data, listType)
        } ?: let { return Collections.emptyList() }
    }

    @TypeConverter
    fun photoEntityListToString(list: List<PhotoEntity>): String {
        return gson.toJson(list)
    }
}

class UserEntityTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun stringToUserEntityList(data: String?): List<UserEntity> {
        data?.let {
            val listType = object : TypeToken<List<UserEntity>>() {}.type
            return gson.fromJson<List<UserEntity>>(data, listType)
        } ?: let { return Collections.emptyList() }
    }

    @TypeConverter
    fun userEntityListToString(list: List<UserEntity>): String {
        return gson.toJson(list)
    }
}
