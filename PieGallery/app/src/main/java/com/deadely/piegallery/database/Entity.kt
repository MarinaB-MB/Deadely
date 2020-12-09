package com.deadely.piegallery.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user_table")
@Parcelize
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    @NonNull
    var id: String,
    var username: String?,
    var name: String?,
    var firstName: String?,
    var lastName: String?,
    var twitterUsername: String?,
    @Embedded
    var profileImage: ProfileImageEntity?,
    var instagramUsername: String?
) : Parcelable

@Entity(tableName = "profile_image_table")
@Parcelize
data class ProfileImageEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "profile_image_small")
    var small: String,
    var medium: String?,
    var large: String?
) : Parcelable
