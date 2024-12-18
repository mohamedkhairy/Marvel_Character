package com.example.home


import com.example.home.data.remote.dto.CharactersResponse
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
}

fun serializeArticleData(jsonData: String): CharactersResponse
     = json.decodeFromString<CharactersResponse>(jsonData)
