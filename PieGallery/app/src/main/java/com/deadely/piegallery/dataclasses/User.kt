package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @SerializedName("id")
    var id: String?,

    @SerializedName("username")
    var username: String?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("first_name")

    var firstName: String?,

    @SerializedName("last_name")

    var lastName: String?,

    @SerializedName("twitter_username")

    var twitterUsername: String?,

    @SerializedName("profile_image")

    var profileImage: ProfileImage?,

    @SerializedName("instagram_username")

    var instagramUsername: String?

) : Parcelable
