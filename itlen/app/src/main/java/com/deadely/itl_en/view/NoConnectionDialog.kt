package com.deadely.itl_en.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.deadely.itl_en.R

class NoConnectionDialog(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_error_connection);
        val close = findViewById<Button>(R.id.btnCloseDialog)
        close.setOnClickListener { dismiss() }
    }
}
