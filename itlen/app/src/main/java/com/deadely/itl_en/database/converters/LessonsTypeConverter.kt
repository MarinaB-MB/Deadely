package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Lesson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*


class LessonsTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun stringToLessonList(data: String?): List<Lesson?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Lesson>?>() {}.type
        return gson.fromJson<List<Lesson>>(data, listType)
    }

    @TypeConverter
    fun lessonListToString(list: List<Lesson>?): String? {
        return gson.toJson(list)
    }
}