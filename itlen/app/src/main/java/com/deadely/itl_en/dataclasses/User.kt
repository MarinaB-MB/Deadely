package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("_id") val _id: String,
        @SerializedName("email") val email: String,
        @SerializedName("active") val active: Boolean,
        @SerializedName("password") val password: String,
        @SerializedName("name") val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readByte() != 0.toByte(),
            parcel.readString()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(email)
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeString(password)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}