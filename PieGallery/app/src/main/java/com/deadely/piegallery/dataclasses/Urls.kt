package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Urls(
    @SerializedName("raw")
    private val raw: String?,
    @SerializedName("full")
    val full: String?,
    @SerializedName("regular")
    private val regular: String?,
    @SerializedName("small")
    private val small: String?,
    @SerializedName("thumb")
    private val thumb: String?
) : Parcelable
