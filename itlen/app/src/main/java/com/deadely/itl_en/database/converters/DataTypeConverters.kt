package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.model.Group
import com.deadely.itl_en.model.User
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

class DateTypeConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

class StringTypeConverter {
    @TypeConverter
    fun getString(str: List<String?>?): String? {
        if (str == null) return null
        val pictures = StringBuilder()
        for (s in str) pictures.append(s).append(",")
        return pictures.toString()
    }

    @TypeConverter
    fun setString(str: String?): ArrayList<Array<String>>? {
        return if (str == null) null else ArrayList(listOf(str.split(",".toRegex()).toTypedArray()))
    }
}

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

class WordTypeConverter : Serializable {
    val gson = Gson()

    @TypeConverter
    fun toList(data: String?): List<Group.Lesson.Word?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Group.Lesson.Word>?>() {}.type
        return gson.fromJson<List<Group.Lesson.Word>>(data, listType)
    }

    @TypeConverter
    fun fromList(list: List<Group.Lesson.Word>?): String? {
        return gson.toJson(list)
    }

}