package com.example.details.data.repository

import com.example.core.sharedData.CharacterDetails
import com.example.core.sharedData.CharacterResources
import com.example.core.sharedData.ResourcesData
import com.example.details.data.mapper.CharacterDetailsMapper
import com.example.details.data.mapper.CharacterResourcesMapper
import com.example.details.data.remote.service.details.MarvelCharacterDetailsService
import com.example.details.domain.repository.CharacterDetailsRepository
import javax.inject.Inject

class CharacterDetailsRepositoryImp @Inject constructor(
    private val service: MarvelCharacterDetailsService,
    private val charactersMapper: CharacterDetailsMapper,
    private val characterResourcesMapper: CharacterResourcesMapper
    ) : CharacterDetailsRepository {


    override suspend fun callMarvelCharacterDetails(characterId: Int): CharacterDetails? =
        service.callMarvelCharacterDetails(characterId)?.let(charactersMapper::map)

    override suspend fun callCharacterResource(resource: CharacterResources): ResourcesData? =
        service.callCharacterResource(resource.collectionURI)?.let {
            characterResourcesMapper.setResourceKey(resource.resourceKey)
            characterResourcesMapper.map(it)
        }

}