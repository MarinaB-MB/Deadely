package com.example.fb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Group(
    val _id: String,
    val title: String,
    val image: String,
    val lessons: List<Lesson>
) : Parcelable {
    @Parcelize
    data class Lesson(
        val _id: String,
        val title: String,
        val words: List<Word>
    ) : Parcelable {
        @Parcelize
        data class Word(
            val _id: String,
            val word: String,
            val tr: String,
            val translate: String
        ) : Parcelable
    }
}