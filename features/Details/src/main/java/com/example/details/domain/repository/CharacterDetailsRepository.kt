package com.example.details.domain.repository

import com.example.core.sharedData.CharacterDetails
import com.example.core.sharedData.CharacterResources
import com.example.core.sharedData.ResourcesData


interface CharacterDetailsRepository {

    suspend fun callMarvelCharacterDetails(characterId: Int): CharacterDetails?

    suspend fun callCharacterResource(resource: CharacterResources): ResourcesData?
}