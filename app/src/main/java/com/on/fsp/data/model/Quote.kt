package com.on.fsp.data.model

import com.google.gson.annotations.SerializedName

data class Quote(
    @SerializedName("image")
    val avatar: String,
    @SerializedName("by")
    val by: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("quote")
    val quote: String,
)
