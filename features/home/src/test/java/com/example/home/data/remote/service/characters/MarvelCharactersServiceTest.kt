package com.example.home.data.remote.service.characters

import com.example.home.engine.MarvelCharactersServiceFake
import com.example.home.engine.ServiceResponseType
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MarvelCharactersServiceTest {

    private val expectedCode = 200
    private val invalidOffset = 1001
    private val testOffset = 10

    @Test
    fun `test MarvelCharacters service with success response`() =  runBlocking {
        // setup
        val marvelCharactersService = MarvelCharactersServiceFake.build(
            type = ServiceResponseType.GoodData // good data
        )

        // execute
        val response = marvelCharactersService.callMarvelCharacters(testOffset)

        // verify
        Assert.assertEquals(expectedCode, response?.code)
    }

    @Test
    fun `test MarvelCharacters service with bad request`() {
        Assert.assertThrows(NoTransformationFoundException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val marvelCharactersService = MarvelCharactersServiceFake.build(
                    type = ServiceResponseType.InvalidData
                )

                // execute
                marvelCharactersService.callMarvelCharacters(invalidOffset)
            }
        }
    }
    @Test
    fun `test MarvelCharacters service with invalid response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val marvelCharactersService = MarvelCharactersServiceFake.build(
                    type = ServiceResponseType.InvalidData
                )

                // execute
                marvelCharactersService.callMarvelCharacters(testOffset)
            }
        }
    }



    @Test
    fun `test MarvelCharacters service with not found response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val marvelCharactersService = MarvelCharactersServiceFake.build(
                    type = ServiceResponseType.Http404
                )

                // execute
                marvelCharactersService.callMarvelCharacters(testOffset)
            }
        }
    }

    @Test
    fun `test MarvelCharacters service with Empty response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val marvelCharactersService = MarvelCharactersServiceFake.build(
                    type = ServiceResponseType.EmptyResponse
                )

                // execute
                marvelCharactersService.callMarvelCharacters(testOffset)
            }
        }
    }
}