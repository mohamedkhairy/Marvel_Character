package com.example.core.sharedData

data class CharacterDetails(
    val id: Int,
    val name: String,
    val description: String?,
    val resourceURI: String?,
    val thumbnail: String?,
    val image: String?,
    var characterResources: List<CharacterResources?> = emptyList()
)
