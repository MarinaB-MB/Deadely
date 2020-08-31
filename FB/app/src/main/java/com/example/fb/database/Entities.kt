package com.example.fb.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fb.model.Group
import com.example.fb.model.User
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
    @SerializedName("stats") val stats: List<User.Stat>
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

fun UserEntity.mapToUser(): User {
    return User(_id, name, email, password, stats, active)
}


fun User.mapToUserEntity(): UserEntity {
    return UserEntity(_id!!, email, active, password, name, stats)
}

fun List<UserEntity>.mapToUserList(): List<User> {
    return map { it.mapToUser() }
}
