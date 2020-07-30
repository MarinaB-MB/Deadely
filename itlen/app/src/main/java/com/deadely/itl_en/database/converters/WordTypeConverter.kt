package com.deadely.itl_en.database.converters

import androidx.room.TypeConverter
import com.deadely.itl_en.dataclasses.Words
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


class WordTypeConverter : Serializable {
    @TypeConverter
    fun fromList(wordList: List<Words>): String? {
        if (wordList == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Words>>() {}.type
        return gson.toJson(wordList, type)
    }

    @TypeConverter
    fun toList(optionValuesString: String?): List<Words>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<Words>>() {}.type
        return gson.fromJson<List<Words>>(optionValuesString, type)
    }
}