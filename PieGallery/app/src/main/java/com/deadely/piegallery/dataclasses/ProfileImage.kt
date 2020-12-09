package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileImage(
    @SerializedName("small")
    var small: String,
    @SerializedName("medium")
    var medium: String?,
    @SerializedName("large")
    var large: String?
) : Parcelable
