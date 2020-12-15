package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchRequest(
    @SerializedName("results") val results: List<Photo>,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val totalPages: Int
) : Parcelable
