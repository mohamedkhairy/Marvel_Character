package com.example.network.remoteBase

import androidx.compose.ui.geometry.Offset
import com.example.marvelcharacter.core.network.BuildConfig
import com.example.network.remoteBase.Utils.hash
import com.example.network.remoteBase.Utils.ts
import io.ktor.http.URLBuilder
import io.ktor.http.appendPathSegments

object Endpoints {

    const val BASE_URL = BuildConfig.BASE_URL
    const val CHARACTERS_URL = "v1/public/characters"


    fun CHARACTERS_API(offset: Int) =
        URLBuilder(BASE_URL).apply {
            appendPathSegments(CHARACTERS_URL)
            parameters.append("ts", ts)
            parameters.append("apikey", BuildConfig.API_KEY)
            parameters.append("hash", hash())
            parameters.append("offset", offset.toString())
            parameters.append("limit", "10")
        }.build()


}