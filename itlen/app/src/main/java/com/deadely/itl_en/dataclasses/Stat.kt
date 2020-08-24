package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "stat_table")
data class Stat(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "stat_id")
        @SerializedName("_id") @NonNull val _id: String,
        @SerializedName("date") val date: Date,
        @SerializedName("count_all") val count_all: Int,
        @SerializedName("count_success") val count_success: Int,
        @SerializedName("count_fail") val count_fail: Int
) : Parcelable