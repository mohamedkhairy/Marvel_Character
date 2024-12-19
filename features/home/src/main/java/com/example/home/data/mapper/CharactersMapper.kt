package com.example.home.data.mapper

import com.example.core.sharedData.CharacterResources
import com.example.core.sharedData.MarvelCharacter
import com.example.core.sharedData.ResourceKey
import com.example.home.data.remote.dto.CharactersResponse
import com.example.home.data.remote.dto.Result
import com.example.utils.mapper.BaseMapper
import javax.inject.Inject


class CharactersMapper @Inject constructor() :
    BaseMapper<CharactersResponse?, List<MarvelCharacter>?> {
    override fun map(model: CharactersResponse?): List<MarvelCharacter>? =
        model?.let {
            it.data.results?.map { character ->
                MarvelCharacter(
                    total = it.data.total,
                    id = character.id,
                    name = character.name,
                    description = character.description,
                    resourceURI = character.resourceURI,
                    thumbnail = character.thumbnail.getImageUrl(),
                    characterResources = getResources(character)
                )
            }
        }


    private fun getResources(results: Result): List<CharacterResources?> {
        val comic = results.comics?.let {
            CharacterResources(
                collectionURI = it.collectionURI,
                resourceKey = ResourceKey.COMICS
            )
        }
        val events = results.events?.let {
            CharacterResources(
                collectionURI = it.collectionURI,
                resourceKey = ResourceKey.EVENTS
            )
        }
        val series = results.series?.let {
            CharacterResources(
                collectionURI = it.collectionURI,
                resourceKey = ResourceKey.SERIES
            )
        }
        val stories = results.stories?.let {
            CharacterResources(
                collectionURI = it.collectionURI,
                resourceKey = ResourceKey.STORIES
            )
        }

        return listOf(comic, events, series, stories)
    }
}
