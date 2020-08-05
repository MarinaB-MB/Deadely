package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "lessons_table")
data class Lesson(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "lesson_id")
        @NonNull
        @SerializedName("_id") val _id: String,
        @ColumnInfo(name = "lesson_checked")
        @SerializedName("checked") val checked: Boolean,
        @ColumnInfo(name = "lesson_title")
        @SerializedName("title") val title: String,
        @SerializedName("words") val words: List<Words>,
        @Embedded
        @SerializedName("group") val group: Group) : Parcelable