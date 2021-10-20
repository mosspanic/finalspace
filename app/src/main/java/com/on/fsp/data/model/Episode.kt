package com.on.fsp.data.model
import com.google.gson.annotations.SerializedName
data class Episode (
    @SerializedName("img_url")
    val avatar: String,
    @SerializedName("air_date")
    val air_date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
)