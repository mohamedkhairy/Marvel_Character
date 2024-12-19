package com.example.home.domain.useCase

import com.example.core.sharedData.MarvelCharacter
import com.example.home.domain.repository.MarvelCharactersRepository
import com.example.utils.dispatchers.IoDispatcher
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

open class MarvelCharactersUseCase @Inject constructor(
    private val marvelCharactersRepository: MarvelCharactersRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Int, List<MarvelCharacter>?>(ioDispatcher) {

    override suspend fun execute(parameters: Int): Flow<List<MarvelCharacter>?> = flow {
        emit(marvelCharactersRepository.getMarvelCharacters(parameters))
    }

}

