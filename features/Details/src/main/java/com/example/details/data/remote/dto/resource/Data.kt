package com.example.details.data.remote.dto.resource


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("count")
    val count: Int,
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("results")
    val resourceResults: List<ResourceResult>?,
    @SerialName("total")
    val total: Int
){
    fun getResourceList(): List<ResourceResult>? =
        if (resourceResults.isNullOrEmpty()) null
        else resourceResults

}