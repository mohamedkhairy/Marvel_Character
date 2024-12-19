package com.example.home.utils

import com.example.core.sharedData.MarvelCharacter

object FakeData {

    val charactersList = listOf(
        MarvelCharacter(total = 20, id = 550, name = "Spider Man", thumbnail = "thumbnail", description = "description", resourceURI = "resourceURI" , characterResources = emptyList()),
        MarvelCharacter(total = 20, id = 1100, name = "Iron Man", thumbnail = "thumbnail1", description = "description1", resourceURI = "resourceURI1", characterResources = emptyList()),
        MarvelCharacter(total = 20, id = 1101, name = "Captain America", thumbnail = "thumbnail2", description = "description2", resourceURI = "resourceURI2", characterResources = emptyList())
    )


}