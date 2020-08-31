package com.deadely.itl_en.utils

import android.view.View
import java.text.SimpleDateFormat
import java.util.*

class Utils {
    fun formatDate(date: Date): String {
        return SimpleDateFormat("YYYY MM DD").format(date)
    }
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeGone() {
    visibility = View.GONE
}