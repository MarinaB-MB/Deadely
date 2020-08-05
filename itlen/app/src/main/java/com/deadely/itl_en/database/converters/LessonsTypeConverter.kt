package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Lesson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable


class LessonsTypeConverter : Serializable {

    @TypeConverter
    fun fromLessonList(photoList: List<Lesson>?): String? {
        return if (photoList.isNullOrEmpty()) null
        else {
            val gson = Gson()
            val type = object : TypeToken<List<Lesson>?>() {}.type
            gson.toJson(photoList, type)
        }
    }


    @TypeConverter
    fun toLessonList(optionValuesString: String?): List<Lesson>? {
        return if (optionValuesString.isNullOrEmpty()) null
        else {
            val gson = Gson()
            val type = object : TypeToken<List<Lesson>?>() {}.type
            gson.fromJson<List<Lesson>>(optionValuesString, type)
        }
    }

}