package com.example.details.data.remote.service.details

import com.example.details.data.remote.dto.details.CharacterDetailsResponse
import com.example.details.data.remote.dto.resource.ResourceResponse


interface MarvelCharacterDetailsService {

    suspend fun callMarvelCharacterDetails(characterId: Int): CharacterDetailsResponse?

    suspend fun callCharacterResource(resourceURI: String): ResourceResponse?

}
