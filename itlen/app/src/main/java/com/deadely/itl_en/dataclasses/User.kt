package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "user_id")
        @NonNull
        @SerializedName("_id") val _id: String,
        @SerializedName("email") val email: String,
        @SerializedName("active") val active: Boolean,
        @SerializedName("password") val password: String,
        @SerializedName("name") val name: String?
) : Parcelable