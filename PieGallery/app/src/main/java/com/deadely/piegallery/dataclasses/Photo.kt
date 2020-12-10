package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id")
    var id: String?,
    @SerializedName("color")
    var color: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("width")
    var width: Int?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("alt_description")
    var altDescription: String?,
    @SerializedName("urls")
    var urls: Urls?,
    @SerializedName("likes")
    var likes: Int?,
    @SerializedName("liked_by_user")
    var likedByUser: Boolean?,
    @SerializedName("user")
    var user: User?,
    @Transient
    var isFavorite: Boolean = false
) : Parcelable
