package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*


class UserTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<User?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<User>?>() {}.type
        return gson.fromJson<List<User>>(data, listType)
    }

    @TypeConverter
    fun fromList(list: List<User>?): String? {
        return gson.toJson(list)
    }

}