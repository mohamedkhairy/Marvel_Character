package com.example.home.engine

import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.data.remote.service.characters.MarvelCharactersServiceImpl
import com.example.home.fakeData.MarvelCharactersEmpty
import com.example.home.fakeData.MarvelCharactersInvalid
import com.example.home.fakeData.MarvelCharactersValid
import com.example.network.remoteBase.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.engine.mock.respondError
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.http.hostWithPort
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MarvelCharactersServiceFake {

    companion object Factory {

        private val Url.hostWithPortIfRequired: String get() = if (port == protocol.defaultPort) host else hostWithPort
        private val Url.fullUrl: String get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"

        fun build(
            type: ServiceResponseType
        ): MarvelCharactersService {
            val client = HttpClient(MockEngine) {
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
                engine {
                    addHandler { request ->
                        when (request.url.fullUrl) {
                            Endpoints.CHARACTERS_API(10).fullUrl -> {
                                val responseHeaders = headersOf(
                                    "Content-Type" to listOf("application/json", "charset=utf-8")
                                )
                                when(type){
                                    is ServiceResponseType.EmptyResponse -> {
                                        respond(
                                            MarvelCharactersEmpty.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.EmptyResultList -> {
                                        respond(
                                            MarvelCharactersValid.emptyCharactersResult,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.InvalidData -> {
                                        respond(
                                            MarvelCharactersInvalid.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.GoodData -> {
                                        respond(
                                            MarvelCharactersValid.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.Http404 -> {
                                        respondError(
                                            status = HttpStatusCode.NotFound,
                                            headers = responseHeaders
                                        )
                                    }
                                }
                            }
                            else -> respondBadRequest()
                        }
                    }
                }
            }
            return MarvelCharactersServiceImpl(client)
        }
    }
}