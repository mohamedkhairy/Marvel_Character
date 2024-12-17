package com.example.home.domain.repository

import com.example.core.sharedData.MarvelCharacter


interface MarvelCharactersRepository {
    suspend fun getMarvelCharacters(period: Int): List<MarvelCharacter>?

}