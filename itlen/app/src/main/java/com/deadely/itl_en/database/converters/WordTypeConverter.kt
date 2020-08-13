package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Words
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*


class WordTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<Words?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Words>?>() {}.type
        return gson.fromJson<List<Words>>(data, listType)
    }

    @TypeConverter
    fun fromList(list: List<Words>?): String? {
        return gson.toJson(list)
    }

}