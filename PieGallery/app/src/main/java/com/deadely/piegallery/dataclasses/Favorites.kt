package com.deadely.piegallery.dataclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorites(
    var id: Int = 0,
    var photo: Photo? = null
) : Parcelable {
    constructor(photo: Photo?) : this() {
        this.photo = photo
    }
}
