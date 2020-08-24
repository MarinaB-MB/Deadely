package com.deadely.itl_en.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    fun formatDate(date: Date): String {
        return SimpleDateFormat("YYYY MM DD").format(date)
    }
}