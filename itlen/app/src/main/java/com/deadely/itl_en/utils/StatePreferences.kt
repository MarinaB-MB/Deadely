package com.deadely.itl_en.utils

import android.content.Context

class StatePreferences(val context: Context, private val key: String) : Preferences(context, key) {
    var isFirstSignIn by booleanPref()
}