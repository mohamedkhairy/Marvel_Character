package com.example.home.data.repository


import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.mapper.CharactersMapper
import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.domain.repository.MarvelCharactersRepository
import com.example.home.engine.MarvelCharactersServiceFake
import com.example.home.engine.ServiceResponseType
import com.example.home.fakeData.MarvelCharactersValid.getCharactersResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MarvelCharactersRepositoryTest {


    private val expectedResultSize = 2
    private val emptyResultSize = 0
    private val offset = 10
    private val validResult = getCharactersResponse()

    private lateinit var repository: MarvelCharactersRepository
    private lateinit var service: MarvelCharactersService
    private lateinit var mapper: CharactersMapper

    @Before
    fun setUp() {
        mapper = CharactersMapper()
    }

    @Test
    fun `MarvelCharactersRepository fetches data from API and maps to MarvelCharacters successfully`() = runBlocking {
        // Setup
        service = MarvelCharactersServiceFake.build(
            type = ServiceResponseType.GoodData
        )
        repository = MarvelCharactersRepositoryImp(service, mapper)


        // Execute
        val result = repository.getMarvelCharacters(offset)

        // Assert
        assertEquals(expectedResultSize, result?.size)
        assertEquals(validResult.data.results?.first()?.id, result?.firstOrNull()?.id)

    }

    @Test
    fun `MarvelCharactersRepository fetches empty data from API and maps to MarvelCharacters`() = runBlocking {
        // Setup
        service = MarvelCharactersServiceFake.build(
            type = ServiceResponseType.EmptyResultList
        )
        repository = MarvelCharactersRepositoryImp(service, mapper)


        // Execute
        val result = repository.getMarvelCharacters(offset)

        // Assert
        assertEquals(emptyResultSize, result?.size)
        assertEquals(emptyList<MarvelCharacter>(), result)

    }
}