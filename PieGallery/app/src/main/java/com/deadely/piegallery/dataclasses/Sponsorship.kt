package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sponsorship(
    @SerializedName("impression_urls")
    var impressionUrls: List<String>,
    @SerializedName("tagline")
    var tagline: String?,
    @SerializedName("tagline_url")
    var taglineUrl: String?,
    @SerializedName("sponsor")
    var sponsor: Sponsor?
) : Parcelable
