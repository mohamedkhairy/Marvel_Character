package com.example.core.sharedData

data class ResourcesData(
    val resourceKey: ResourceKey,
    val pairList: List<ResourcesPair>
)

data class ResourcesPair(
    val title: String,
    val thumbnail: String?,
    val image: String?
)