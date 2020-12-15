package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(
    @SerializedName("id") var id: String,
    @SerializedName("username") var username: String,
    @SerializedName("name") var name: String,
    @SerializedName("first_name") var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("twitter_username") var twitterUsername: String,
    @SerializedName("portfolio_url") var portfolioUrl: String,
    @SerializedName("profile_image") var profileImage: ProfileImage,
    @SerializedName("instagram_username") var instagramUsername: String,
    @SerializedName("total_collections") var totalCollections: Int,
    @SerializedName("total_likes") var totalLikes: Int,
    @SerializedName("total_photos") var totalPhotos: Int,
    @SerializedName("photos") var photos: List<UserPhotos>,
    @SerializedName("followers_count") var followersCount: Int,
    @SerializedName("following_count") var followingCount: Int,
    @SerializedName("allow_messages") var allowMessages: Boolean,
) : Parcelable

@Parcelize
data class UserPhotos(
    @SerializedName("id") var id: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("blur_hash") var blurHash: String,
    @SerializedName("urls") var urls: Urls
) : Parcelable
