package com.deadely.itl_en.dataclasses

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Data(
        val deviceId: String,
        @PrimaryKey(autoGenerate = false)
        val _id: String,
        val users: List<User>
) : Parcelable {
}
