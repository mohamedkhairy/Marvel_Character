package com.example.details.data.remote.dto.resource


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResourceResult(
    @SerialName("id")
    val id: Int,
    @SerialName("thumbnail")
    val thumbnail: Thumbnail?,
    @SerialName("title")
    val title: String
)