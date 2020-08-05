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
@Entity(tableName = "stat_table")
data class Stat(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "star_id")
        @SerializedName("_id") @NonNull val _id: String,
        @SerializedName("date") val date: String,
        @SerializedName("words") val words: List<Words>,
        @Embedded
        @SerializedName("user") val user: User
) : Parcelable