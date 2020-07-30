package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "group_table")
data class Group(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "group_id")
        @NonNull
        @SerializedName("_id") val _id: String,
        @SerializedName("image") val image: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("lessons") val lessons: List<Lesson>? = null) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(Lesson)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(image)
        parcel.writeString(title)
        parcel.writeTypedList(lessons)
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