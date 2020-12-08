package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile_Image(
    @SerializedName("small")
    var small: String,
    @SerializedName("medium")
    var medium: String?,
    @SerializedName("large")
    var large: String?
) : Parcelable
