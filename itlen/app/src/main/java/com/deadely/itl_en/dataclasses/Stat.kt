package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Stat(

        @SerializedName("_id") val _id: String,
        @SerializedName("date") val date: String,
        @SerializedName("words") val words: List<Words>,
        @SerializedName("user") val user: List<User>
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.createTypedArrayList(Words)!!,
            parcel.createTypedArrayList(User)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(date)
        parcel.writeTypedList(words)
        parcel.writeTypedList(user)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stat> {
        override fun createFromParcel(parcel: Parcel): Stat {
            return Stat(parcel)
        }

        override fun newArray(size: Int): Array<Stat?> {
            return arrayOfNulls(size)
        }
    }
}