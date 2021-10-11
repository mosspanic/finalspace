package com.on.fsp.data.model
import com.google.gson.annotations.SerializedName
data class Location (
    @SerializedName("img_url")
    val avatar: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)