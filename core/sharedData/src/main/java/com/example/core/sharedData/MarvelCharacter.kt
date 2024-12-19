package com.example.core.sharedData

data class MarvelCharacter(
    val id: Int,
    val name: String,
    val description: String?,
    val resourceURI: String?,
    val thumbnail: String?,
    val total: Int,
    val characterResources: List<CharacterResources?>
)
