package com.example.details.data.remote.dto.resource


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResourceResponse(
    @SerialName("code")
    val code: Int,
    @SerialName("data")
    val data: Data,
    @SerialName("etag")
    val etag: String,
    @SerialName("status")
    val status: String
)