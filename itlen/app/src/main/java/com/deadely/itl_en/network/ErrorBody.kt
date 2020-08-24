package com.deadely.itl_en.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ErrorBody(
        val field: String,
        val message: List<String>
) : Parcelable {

}
