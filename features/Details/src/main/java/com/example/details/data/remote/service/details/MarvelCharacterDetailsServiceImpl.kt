package com.example.details.data.remote.service.details

import com.example.details.data.remote.dto.details.CharacterDetailsResponse
import com.example.details.data.remote.dto.resource.ResourceResponse
import com.example.network.remoteBase.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class MarvelCharacterDetailsServiceImpl @Inject constructor(val httpClient: HttpClient) :
    MarvelCharacterDetailsService {


    override suspend fun callMarvelCharacterDetails(characterId: Int): CharacterDetailsResponse? =
        httpClient.get(Endpoints.CHARACTERS_DETAILS_API(characterId))
            .body<CharacterDetailsResponse?>()

    override suspend fun callCharacterResource(resourceURI: String): ResourceResponse? =
        httpClient.get(Endpoints.RESOURCE_API(resourceURI))
            .body<ResourceResponse?>()


}