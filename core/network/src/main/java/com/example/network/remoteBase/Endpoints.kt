package com.example.network.remoteBase

import com.example.marvelcharacter.core.network.BuildConfig
import com.example.network.remoteBase.Utils.hash
import com.example.network.remoteBase.Utils.ts
import io.ktor.http.URLBuilder
import io.ktor.http.appendPathSegments

object Endpoints {

    const val BASE_URL = BuildConfig.BASE_URL
    const val CHARACTERS_URL = "v1/public/characters"
    private val API_KEY = BuildConfig.API_KEY

    fun CHARACTERS_API(offset: Int) =
        URLBuilder(BASE_URL).apply {
            appendPathSegments(CHARACTERS_URL)
            parameters.append("ts", ts)
            parameters.append("apikey", API_KEY)
            parameters.append("hash", hash())
            parameters.append("offset", offset.toString())
            parameters.append("limit", "10")
        }.build()

    fun CHARACTERS_DETAILS_API(characterId: Int) =
        URLBuilder(BASE_URL).apply {
            appendPathSegments(CHARACTERS_URL)
            appendPathSegments("/$characterId")
            parameters.append("ts", ts)
            parameters.append("apikey", API_KEY)
            parameters.append("hash", hash())
        }.build()


    fun RESOURCE_API(resourceURI: String) =
        URLBuilder(resourceURI).apply {
            parameters.append("ts", ts)
            parameters.append("apikey", API_KEY)
            parameters.append("hash", hash())
        }.build()

}