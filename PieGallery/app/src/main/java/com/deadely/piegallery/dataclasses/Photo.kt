package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    @SerializedName("id")
    var id: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("promoted_at")
    var promotedAt: String?,
    @SerializedName("width")
    var width: Int?,
    @SerializedName("height")
    var height: Int?,
    @SerializedName("color")
    var color: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("alt_description")
    var altDescription: String?,
    @SerializedName("urls")
    var urls: Urls?,
    @SerializedName("links")
    var links: Links?,
    @SerializedName("categories")
    var categories: List<String>?,
    @SerializedName("likes")
    var likes: Int?,
    @SerializedName("liked_by_user")
    var likedByUser: Boolean?,
    @SerializedName("current_user_collections")
    var currentUserCollections: List<String>?,
    @SerializedName("sponsorship")
    var sponsorship: Sponsorship?,
    @SerializedName("user")
    var user: User?
) : Parcelable
