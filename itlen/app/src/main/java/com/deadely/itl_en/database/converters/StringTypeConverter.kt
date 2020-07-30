package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter

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
