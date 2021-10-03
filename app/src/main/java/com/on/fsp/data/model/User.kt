package com.on.fsp.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("img_url")
    val avatar: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)
