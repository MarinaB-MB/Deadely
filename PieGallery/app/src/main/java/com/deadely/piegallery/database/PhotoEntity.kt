package com.deadely.piegallery.database

import android.os.Parcelable
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
