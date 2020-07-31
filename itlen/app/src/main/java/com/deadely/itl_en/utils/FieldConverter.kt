package com.deadely.itl_en.utils

import com.deadely.itl_en.App

class FieldConverter() {

    fun getString(resId: Int): String {
        return App.instance.resources.getString(resId)
    }
}