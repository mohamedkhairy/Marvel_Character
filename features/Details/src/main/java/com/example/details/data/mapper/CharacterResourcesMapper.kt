package com.example.details.data.mapper

import com.example.core.sharedData.ResourceKey
import com.example.core.sharedData.ResourcesData
import com.example.core.sharedData.ResourcesPair
import com.example.details.data.remote.dto.resource.ResourceResponse
import com.example.utils.mapper.BaseMapper
import javax.inject.Inject

class CharacterResourcesMapper @Inject constructor() :
    BaseMapper<ResourceResponse?, ResourcesData?> {

    private var resourceKey: ResourceKey = ResourceKey.NONE

    override fun map(model: ResourceResponse?): ResourcesData? =
        when (resourceKey) {
            ResourceKey.COMICS -> {
                mapResources(model)
            }

            ResourceKey.EVENTS -> {
                mapResources(model)
            }

            ResourceKey.SERIES -> {
                mapResources(model)
            }

            ResourceKey.STORIES -> {
                mapResources(model)
            }

            ResourceKey.NONE -> {
                mapResources(model)
            }
        }

    private fun mapResources(model: ResourceResponse?): ResourcesData? =
        model?.let {
            val resResult = it.data.getResourceList()
            val pairList = resResult?.map { resource ->
                ResourcesPair(
                    title = resource.title,
                    thumbnail = resource.thumbnail?.getThumbnailUrl(),
                    image = resource.thumbnail?.getImageUrl()
                )
            } ?: run { return@let null }

                ResourcesData(
                    resourceKey = resourceKey,
                    pairList = pairList
                )
        }

    fun setResourceKey(resourceKey: ResourceKey) {
        this.resourceKey = resourceKey
    }

}

