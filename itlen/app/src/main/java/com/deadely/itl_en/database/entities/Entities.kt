package com.deadely.itl_en.database.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deadely.itl_en.model.Group
import com.deadely.itl_en.model.User
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class UserEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "user_id")
        @NonNull
        @SerializedName("_id") val _id: String,

        @SerializedName("email") val email: String,

        @SerializedName("active") var active: Boolean,

        @SerializedName("password") val password: String,

        @SerializedName("name") val name: String,
        @SerializedName("stats") val stats: List<User.Stat>?
) : Parcelable

@Parcelize
@Entity(tableName = "group_table")
data class GroupEntity(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "group_id")
        @NonNull
        @SerializedName("_id") val _id: String,

        @SerializedName("image") val image: String,

        @SerializedName("title") val title: String,

        @ColumnInfo(name = "lessons")
        @SerializedName("lessons") val lessons: List<Group.Lesson>? = null
) : Parcelable

