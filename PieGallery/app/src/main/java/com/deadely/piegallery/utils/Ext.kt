package com.deadely.piegallery.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}

fun View.makeInvisible() {
    visibility = View.INVISIBLE
}

fun snack(view: View, text: String) {
    Snackbar.make(view, text, Snackbar.LENGTH_LONG).show()
}
