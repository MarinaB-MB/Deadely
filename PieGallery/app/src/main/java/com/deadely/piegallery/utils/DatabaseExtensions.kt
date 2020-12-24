package com.deadely.piegallery.utils

import com.deadely.piegallery.database.PhotoEntity
import com.deadely.piegallery.database.ProfileImageEntity
import com.deadely.piegallery.database.UserEntity
import com.deadely.piegallery.dataclasses.Photo
import com.deadely.piegallery.dataclasses.ProfileImage
import com.deadely.piegallery.dataclasses.User

fun Photo.mapToEntity(): PhotoEntity {
    return PhotoEntity(
        id
            ?: "",
        color, description, width, height, altDescription, urls, likes, likedByUser, user?.mapToEntity(), isFavorite
    )
}

fun PhotoEntity.mapToModel(): Photo {
    return Photo(id, color, description, width, height, altDescription, urls, likes, likedByUser, user?.mapToModel(), isFavorite)
}

fun List<PhotoEntity>.mapToModelList(): List<Photo> {
    return map { it.mapToModel() }
}

fun User.mapToEntity(): UserEntity {
    return UserEntity(
        id
            ?: "",
        username, name, firstName, lastName, twitterUsername, profileImage?.mapToEntity(), instagramUsername
    )
}

fun ProfileImage.mapToEntity(): ProfileImageEntity {
    return ProfileImageEntity(small, medium, large)
}

fun ProfileImageEntity.mapToModel(): ProfileImage {
    return ProfileImage(small, medium, large)
}

fun UserEntity.mapToModel(): User {
    return User(id, username, name, firstName, lastName, twitterUsername, profileImage?.mapToModel(), instagramUsername)
}
