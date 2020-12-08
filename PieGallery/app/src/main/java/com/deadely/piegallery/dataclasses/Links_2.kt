package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links_2(
    @SerializedName("self")
    var self: String?,
    @SerializedName("html")
    var html: String?,
    @SerializedName("photos")
    var photos: String?,
    @SerializedName("likes")
    var likes: String?,
    @SerializedName("portfolio")
    var portfolio: String?,
    @SerializedName("following")
    var following: String?,
    @SerializedName("followers")
    var followers: String?
) : Parcelable
