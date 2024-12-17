package com.example.home.data.remote.service.characters

import com.example.home.data.remote.dto.CharactersResponse
import com.example.network.remoteBase.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class MarvelCharactersServiceImpl @Inject constructor(val httpClient: HttpClient) : MarvelCharactersService {

    override suspend fun callMarvelCharacters(offset: Int): CharactersResponse? =
        httpClient.get(Endpoints.CHARACTERS_API(offset))
            .body<CharactersResponse?>()


}