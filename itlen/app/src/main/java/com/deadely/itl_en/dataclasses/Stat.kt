package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "stat_table")
data class Stat(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "stat_id")
        @SerializedName("_id") @NonNull val _id: String,

        @SerializedName("date") val date: String,

        @SerializedName("words") val words: List<Words>,

        @ColumnInfo(name = "stat_user_id")
        @SerializedName("user_id") val userId: String
) : Parcelable