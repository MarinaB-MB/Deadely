package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Lesson(@SerializedName("_id") val _id: String,
                  @SerializedName("checked") val checked: Boolean,
                  @SerializedName("title") val title: String,
                  @SerializedName("words") val words: List<String>,
                  @SerializedName("group") val group: List<Group>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readByte() != 0.toByte(),
            parcel.readString()!!,
            parcel.createStringArrayList()!!,
            parcel.createTypedArrayList(Group)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeByte(if (checked) 1 else 0)
        parcel.writeString(title)
        parcel.writeStringList(words)
        parcel.writeTypedList(group)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lesson> {
        override fun createFromParcel(parcel: Parcel): Lesson {
            return Lesson(parcel)
        }

        override fun newArray(size: Int): Array<Lesson?> {
            return arrayOfNulls(size)
        }
    }
}