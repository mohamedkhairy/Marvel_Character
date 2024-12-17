package com.example.home.data.remote.service.characters

import com.example.home.data.remote.dto.CharactersResponse

interface MarvelCharactersService {

    suspend fun callMarvelCharacters(offset: Int): CharactersResponse?


}
