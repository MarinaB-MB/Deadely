package com.example.fb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class User(
    val _id: String?,
    val name: String,
    val email: String,
    val password: String,
    val stats: List<Stat>,
    @Transient
    val active: Boolean
) : Parcelable {
    @Parcelize
    data class Stat(
        val _id: String,
        val date: Date,
        val count_all: String,
        val count_success: String,
        val count_fail: String
    ) : Parcelable

    constructor(
        name: String,
        email: String,
        password: String,
        stats: List<Stat>,
        active: Boolean
    ) : this(null, name, email, password, stats, active)
}
