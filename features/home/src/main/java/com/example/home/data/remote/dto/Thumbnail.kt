package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    @SerialName("extension")
    val extension: String,
    @SerialName("path")
    val path: String
){
    fun getImageUrl(): String =
         "$path.$extension"

}