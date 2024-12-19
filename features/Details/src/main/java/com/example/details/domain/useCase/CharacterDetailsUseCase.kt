package com.example.details.domain.useCase

import com.example.core.sharedData.CharacterDetails
import com.example.details.domain.repository.CharacterDetailsRepository
import com.example.utils.dispatchers.IoDispatcher
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterDetailsUseCase @Inject constructor(
    private val characterDetailsRepository: CharacterDetailsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Int, CharacterDetails?>(ioDispatcher) {

    override suspend fun execute(parameters: Int): Flow<CharacterDetails?> = flow {
        emit(characterDetailsRepository.callMarvelCharacterDetails(parameters))
    }

}

