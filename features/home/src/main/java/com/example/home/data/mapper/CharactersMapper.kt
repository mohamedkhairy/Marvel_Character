package com.example.home.data.mapper

import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.remote.dto.CharactersResponse
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
                )
            }
        }

}
