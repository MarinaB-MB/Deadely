package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Words(
        @SerializedName("_id") val _id: String,
        @SerializedName("word") val word: String,
        @SerializedName("tr") val tr: String,
        @SerializedName("checked") val checked: Boolean,
        @SerializedName("translate") val translate: String,
        @SerializedName("lesson") val lesson: List<String>,
        @SerializedName("_created") val _created: String,
        @SerializedName("_changed") val _changed: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readByte() != 0.toByte(),
            parcel.readString()!!,
            parcel.createStringArrayList()!!,
            parcel.readString()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(word)
        parcel.writeString(tr)
        parcel.writeByte(if (checked) 1 else 0)
        parcel.writeString(translate)
        parcel.writeStringList(lesson)
        parcel.writeString(_created)
        parcel.writeString(_changed)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Words> {
        override fun createFromParcel(parcel: Parcel): Words {
            return Words(parcel)
        }

        override fun newArray(size: Int): Array<Words?> {
            return arrayOfNulls(size)
        }
    }

}
