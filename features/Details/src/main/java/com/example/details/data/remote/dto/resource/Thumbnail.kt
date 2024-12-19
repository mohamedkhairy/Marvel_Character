package com.example.details.data.remote.dto.resource


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
){
    fun getThumbnailUrl(): String=
        "$path/portrait_fantastic.$extension"

    fun getImageUrl(): String=
        "$path.$extension"
}