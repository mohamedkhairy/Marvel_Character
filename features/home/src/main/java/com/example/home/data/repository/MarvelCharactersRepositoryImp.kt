package com.example.home.data.repository

import android.util.Log
import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.mapper.CharactersMapper
import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.domain.repository.MarvelCharactersRepository
import com.example.utils.core.toJsonString
import javax.inject.Inject

class MarvelCharactersRepositoryImp @Inject constructor(
    private val service: MarvelCharactersService,
    private val charactersMapper: CharactersMapper,
    ) : MarvelCharactersRepository {

    override suspend fun getMarvelCharacters(offset: Int): List<MarvelCharacter>? {
        val result = service.callMarvelCharacters(offset)
          return  result?.let(
            charactersMapper::map
        )
    }
}