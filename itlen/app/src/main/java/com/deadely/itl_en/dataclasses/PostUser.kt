package com.deadely.itl_en.dataclasses

import com.google.gson.annotations.SerializedName

class PostUser {
    @SerializedName("email")
    private var email: String?

    @SerializedName("password")
    private lateinit var password: String

    @SerializedName("name")
    private lateinit var name: String

    @SerializedName("active")
    private var active: Boolean = true


    constructor(email: String, password: String, name: String, active: Boolean) {
        this.email = email
        this.password = password
        this.name = name
        this.active = active
    }

    constructor(email: String, active: Boolean) {
        this.email = email
        this.active = active
    }
}