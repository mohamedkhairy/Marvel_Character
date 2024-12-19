package com.example.details.data.remote.dto.details


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Url(
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String
)