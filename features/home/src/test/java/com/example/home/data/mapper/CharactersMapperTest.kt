package com.example.home.data.mapper


import com.example.core.sharedData.MarvelCharacter
import com.example.home.fakeData.MarvelCharactersValid
import com.example.home.serializeArticleData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CharactersMapperTest {

    private lateinit var charactersMapper: CharactersMapper

    @Before
    fun setUp() {
        charactersMapper = CharactersMapper()
    }

    @Test
    fun `test charactersMapper maps response to marvelCharacters model correctly`() {
        // setup
        val charactersResponse = serializeArticleData(MarvelCharactersValid.data)

        // execute
        val marvelCharacters = charactersMapper.map(charactersResponse)

        // Assert
        assertEquals(charactersResponse.data.results?.firstOrNull()?.id, marvelCharacters?.firstOrNull()?.id)
        assertEquals(charactersResponse.data.results?.firstOrNull()?.name, marvelCharacters?.firstOrNull()?.name)
    }

    @Test
    fun `charactersMapper maps empty result response to marvelCharacters model`() {
        // setup
        val articleResponse = serializeArticleData(MarvelCharactersValid.emptyCharactersResult)

        // execute
        val article = charactersMapper.map(articleResponse)

        // Assert
        assertEquals(emptyList<MarvelCharacter>(), article)
    }

}