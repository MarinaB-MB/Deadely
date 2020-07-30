package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "words_table")
data class Words(
        @PrimaryKey(autoGenerate = false)
        @NonNull
        @ColumnInfo(name = "words_id")
        @SerializedName("_id") val _id: String,

        @SerializedName("word") val word: String?,

        @SerializedName("tr") val tr: String?,

        @SerializedName("translate") val translate: Boolean,

        @ColumnInfo(name = "words_checked")
        @SerializedName("checked") val checked: Boolean,

        @Embedded
        @SerializedName("lesson") val lesson: Lesson? = null,

        @SerializedName("_created") val _created: String?,

        @SerializedName("_changed") val _changed: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readParcelable(Lesson::class.java.classLoader)!!,
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(word)
        parcel.writeString(tr)
        parcel.writeByte(if (translate) 1 else 0)
        parcel.writeByte(if (checked) 1 else 0)
        parcel.writeParcelable(lesson, flags)
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
