package com.deadely.piegallery.database

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.deadely.piegallery.dataclasses.Urls
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "favorite_table")
@Parcelize
data class PhotoEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "photo_id")
    var id: String,
    var color: String?,
    var description: String?,
    var width: Int?,
    var height: Int?,
    var altDescription: String?,
    @Embedded
    var urls: Urls?,
    var likes: Int?,
    var likedByUser: Boolean?,
    @Embedded
    var user: UserEntity?,
    var isFavorite: Boolean = false
) : Parcelable

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
