package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "lessons_table")
data class Lesson(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "lesson_id")
        @NonNull
        @SerializedName("_id") val _id: String,
        @ColumnInfo(name = "lesson_checked")
        @SerializedName("checked") val checked: Boolean,
        @ColumnInfo(name = "lesson_title")
        @SerializedName("title") val title: String?,
        @SerializedName("words") val words: List<Words>? = null,
        @Embedded
        @SerializedName("group") val group: Group) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.createTypedArrayList(Words),
            parcel.readParcelable(Group::class.java.classLoader)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeByte(if (checked) 1 else 0)
        parcel.writeString(title)
        parcel.writeTypedList(words)
        parcel.writeParcelable(group, flags)
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