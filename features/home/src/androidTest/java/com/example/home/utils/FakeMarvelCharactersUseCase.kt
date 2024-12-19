package com.example.home.utils

import com.example.core.sharedData.MarvelCharacter
import com.example.home.domain.useCase.MarvelCharactersUseCase
//import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.mockito.kotlin.mock

class FakeMarvelCharactersUseCase : MarvelCharactersUseCase(mock() , Dispatchers.IO) {

    override suspend fun execute(parameters: Int): Flow<List<MarvelCharacter>?> {
        return flowOf(
            FakeData.charactersList
        )
    }
}