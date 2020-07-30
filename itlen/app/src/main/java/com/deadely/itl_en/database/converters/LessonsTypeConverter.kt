package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Lesson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


class LessonsTypeConverter : Serializable {
    @TypeConverter
    fun fromList(list: List<Lesson>): String? {
        if (list == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Lesson>>() {}.type
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun toList(optionValuesString: String?): List<Lesson>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Lesson>>() {}.type
        return gson.fromJson<List<Lesson>>(optionValuesString, type)
    }
}