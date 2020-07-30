package com.deadely.itl_en.dataclasses

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "stat_table")
data class Stat(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "star_id")
        @SerializedName("_id") @NonNull val _id: String,
        @SerializedName("date") val date: String?,
        @SerializedName("words") val words: List<Words>? = null,
        @Embedded
        @SerializedName("user") val user: User? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString(),
            parcel.createTypedArrayList(Words)!!,
            parcel.readParcelable(User::class.java.classLoader)!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(date)
        parcel.writeTypedList(words)
        parcel.writeParcelable(user, flags)
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