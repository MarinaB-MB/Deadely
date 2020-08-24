package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Stat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*


class StatTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<Stat?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Stat>?>() {}.type
        return gson.fromJson<List<Stat>>(data, listType)
    }

    @TypeConverter
    fun fromList(list: List<Stat>?): String? {
        return gson.toJson(list)
    }

}