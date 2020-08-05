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
@Entity(tableName = "words_table")
data class Words(
        @PrimaryKey(autoGenerate = false)
        @NonNull
        @ColumnInfo(name = "words_id")
        @SerializedName("_id") val _id: String,

        @SerializedName("word") val word: String,

        @SerializedName("tr") val tr: String,

        @SerializedName("translate") val translate: Boolean,

        @ColumnInfo(name = "words_checked")
        @SerializedName("checked") val checked: Boolean,

        @Embedded
        @SerializedName("lesson") val lesson: Lesson,

        @SerializedName("_created") val _created: String,

        @SerializedName("_changed") val _changed: String
) : Parcelable
