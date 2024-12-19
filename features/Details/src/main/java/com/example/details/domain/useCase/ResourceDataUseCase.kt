package com.example.details.domain.useCase

import com.example.core.sharedData.CharacterResources
import com.example.core.sharedData.ResourcesData
import com.example.details.domain.repository.CharacterDetailsRepository
import com.example.utils.dispatchers.IoDispatcher
import com.example.utils.usecases.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ResourceDataUseCase @Inject constructor(
    private val characterDetailsRepository: CharacterDetailsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<List<CharacterResources>, List<ResourcesData?>>(ioDispatcher) {

    override suspend fun execute(parameters: List<CharacterResources>): Flow<List<ResourcesData?>> = flow {
        parameters.map {
            emit(listOf(characterDetailsRepository.callCharacterResource(it)))
        }
    }

}

