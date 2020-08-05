package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "group_table")
data class Group(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "group_id")
        @NonNull
        @SerializedName("_id") val _id: String,

        @SerializedName("image") val image: String,

        @SerializedName("title") val title: String

//        @ColumnInfo(name = "lessons")
//        @SerializedName("lessons") val lessons: List<Lesson>? = null
) : Parcelable