package com.example.details.data.mapper

import com.example.core.sharedData.CharacterDetails
import com.example.details.data.remote.dto.details.CharacterDetailsResponse
import com.example.utils.mapper.BaseMapper
import javax.inject.Inject

class CharacterDetailsMapper @Inject constructor() :
    BaseMapper<CharacterDetailsResponse?, CharacterDetails?> {

    override fun map(model: CharacterDetailsResponse?): CharacterDetails? =
        model?.let {
            it.data.results.firstOrNull()?.let { character ->
                CharacterDetails(
                    id = character.id,
                    name = character.name,
                    description = character.description,
                    resourceURI = character.resourceURI,
                    thumbnail = character.thumbnail?.getThumbnailUrl(),
                    image = character.thumbnail?.getImageUrl()
                )
            }
        }


}
