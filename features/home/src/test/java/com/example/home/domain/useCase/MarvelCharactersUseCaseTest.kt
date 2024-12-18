package com.example.home.domain.useCase

import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.mapper.CharactersMapper
import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.data.repository.MarvelCharactersRepositoryImp
import com.example.home.domain.repository.MarvelCharactersRepository
import com.example.home.engine.MarvelCharactersServiceFake
import com.example.home.engine.ServiceResponseType
import com.example.home.fakeData.MarvelCharactersValid
import com.example.utils.core.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MarvelCharactersUseCaseTest {


    private val exceptionMessage =
        "Unexpected JSON token at offset 0: Expected start of the object '{', but had 'N' instead at path: \$\n" +
                "JSON input: Not Found"

    private lateinit var repository: MarvelCharactersRepository
    private lateinit var service: MarvelCharactersService
    private lateinit var mapper: CharactersMapper
    private lateinit var useCase: MarvelCharactersUseCase
    private val offset = 10


    @Before
    fun setUp() {
        mapper = CharactersMapper()
    }

    @Test
    fun `test MarvelCharactersUseCase with success data`() =
        runBlocking {
            // Setup
            service = MarvelCharactersServiceFake.build(
                type = ServiceResponseType.GoodData
            )
            repository = MarvelCharactersRepositoryImp(service, mapper)
            useCase = MarvelCharactersUseCase(repository, Dispatchers.IO)

            // Execute
            val result = useCase(offset).toList()

            println(result.size)
            // Assert
            Assert.assertEquals(UiState.Loading<List<MarvelCharacter>>(true), result.first())
            Assert.assertEquals(UiState.Success(MarvelCharactersValid.getMarvelCharactersList()), result[1])
        }


    @Test
    fun `test MarvelCharactersUseCase with failure`() =
        runBlocking {
        // Setup
        service = MarvelCharactersServiceFake.build(
            type = ServiceResponseType.Http404
        )
        repository = MarvelCharactersRepositoryImp(service, mapper)
        useCase = MarvelCharactersUseCase(repository, Dispatchers.IO)

        // Execute
        val result = useCase(offset).toList()
        val error = result[1] as UiState.Error
        val errorMessage = error.throwable?.message

        // Assert
        Assert.assertEquals(result.first(), UiState.Loading<List<MarvelCharacter>>(true))
        Assert.assertEquals(exceptionMessage, errorMessage)

    }
}