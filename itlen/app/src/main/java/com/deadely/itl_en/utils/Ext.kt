package com.deadely.itl_en.utils

import com.deadely.itl_en.database.entities.UserEntity
import com.deadely.itl_en.model.User

fun UserEntity.mapToUser(): User? {
    return User(
            _id = _id,
            name = name,
            email = email,
            password = password,
            stats = stats,
            active = active
    )
}

fun User.mapToUserEntity(): UserEntity {
    return UserEntity(_id!!, email, active, password, name, stats)
}

fun List<UserEntity>.mapToUserList(): List<User?> {
    return map { it.mapToUser() }
}
