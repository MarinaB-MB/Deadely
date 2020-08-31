package com.example.fb.database

import androidx.room.TypeConverter
import com.example.fb.model.Group
import com.example.fb.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*


class LessonsTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun stringToLessonList(data: String?): List<Group.Lesson?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Group.Lesson>?>() {}.type
        return gson.fromJson<List<Group.Lesson>>(data, listType)
    }

    @TypeConverter
    fun lessonListToString(list: List<Group.Lesson>?): String? {
        return gson.toJson(list)
    }
}

class StatTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<User.Stat?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<User.Stat>?>() {}.type
        return gson.fromJson<List<User.Stat>>(data, listType)
    }

    @TypeConverter
    fun fromList(list: List<User.Stat>?): String? {
        return gson.toJson(list)
    }

}