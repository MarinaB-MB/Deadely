package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links(
    @SerializedName("self")
    var self: String?,
    @SerializedName("html")
    var html: String?,
    @SerializedName("download")
    var download: String?,
    @SerializedName("download_location")
    var downloadLocation: String?
) : Parcelable
