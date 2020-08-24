package com.deadely.itl_en.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ErrorResponse(
        val message: String,
        val name: String,
        val list: List<ErrorBody>,
        val status: Int
) : Parcelable {
}