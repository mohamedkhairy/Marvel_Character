package com.example.details.data.remote.dto.details


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Comics(
    @SerialName("available")
    val available: Int,
    @SerialName("collectionURI")
    val collectionURI: String,
    @SerialName("items")
    val items: List<Item>,
    @SerialName("returned")
    val returned: Int
)