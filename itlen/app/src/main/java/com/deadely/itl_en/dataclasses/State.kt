package com.deadely.itl_en.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class State(@PrimaryKey(autoGenerate = true)
            val id: String,
            val isFirstSignIn: Boolean
) {
}