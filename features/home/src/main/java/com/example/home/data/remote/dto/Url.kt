package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Url(
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)