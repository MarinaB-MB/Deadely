package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Group(@SerializedName("_id") val _id: String,
                 @SerializedName("image") val image: List<String>,
                 @SerializedName("title") val title: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.createStringArrayList()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeStringList(image)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Group> {
        override fun createFromParcel(parcel: Parcel): Group {
            return Group(parcel)
        }

        override fun newArray(size: Int): Array<Group?> {
            return arrayOfNulls(size)
        }
    }
}