package com.example.home.fakeData

import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.remote.dto.CharactersResponse
import com.example.home.serializeArticleData
import com.example.utils.core.jsonParse

object MarvelCharactersValid {

    val data = "{\n" +
            "  \"attributionText\": \"Data provided by Marvel. © 2024 MARVEL\",\n" +
            "  \"code\": 200,\n" +
            "  \"data\": {\n" +
            "    \"count\": 10,\n" +
            "    \"limit\": 10,\n" +
            "    \"offset\": 0,\n" +
            "    \"results\": [\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1011334,\n" +
            "        \"name\": \"3-D Man\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1011334\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"Rick Jones has been Hulk\\u0027s best bud since day one, but now he\\u0027s more than a friend...he\\u0027s a teammate! Transformed by a Gamma energy explosion, A-Bomb\\u0027s thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\n" +
            "        \"id\": 1017100,\n" +
            "        \"name\": \"A-Bomb (HAS)\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1017100\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"AIM is a terrorist organization bent on destroying the world.\",\n" +
            "        \"id\": 1009144,\n" +
            "        \"name\": \"A.I.M.\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1009144\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1010699,\n" +
            "        \"name\": \"Aaron Stack\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1010699\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"Formerly known as Emil Blonsky, a spy of Soviet Yugoslavian origin working for the KGB, the Abomination gained his powers after receiving a dose of gamma radiation similar to that which transformed Bruce Banner into the incredible Hulk.\",\n" +
            "        \"id\": 1009146,\n" +
            "        \"name\": \"Abomination (Emil Blonsky)\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1009146\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1016823,\n" +
            "        \"name\": \"Abomination (Ultimate)\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1016823\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1009148,\n" +
            "        \"name\": \"Absorbing Man\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1009148\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1009149,\n" +
            "        \"name\": \"Abyss\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1009149\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1010903,\n" +
            "        \"name\": \"Abyss (Age of Apocalypse)\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1010903\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/3/80/4c00358ec7548\"\n" +
            "        }\n" +
            "      },\n" +
            "      {\n" +
            "        \"description\": \"\",\n" +
            "        \"id\": 1011266,\n" +
            "        \"name\": \"Adam Destine\",\n" +
            "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/characters/1011266\",\n" +
            "        \"thumbnail\": {\n" +
            "          \"extension\": \"jpg\",\n" +
            "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\"\n" +
            "        }\n" +
            "      }\n" +
            "    ],\n" +
            "    \"total\": 1564\n" +
            "  },\n" +
            "  \"status\": \"Ok\"\n" +
            "}"

    
    val emptyCharactersResult = "{\n" +
            "  \"attributionText\": \"Data provided by Marvel. © 2024 MARVEL\",\n" +
            "  \"code\": 200,\n" +
            "  \"data\": {\n" +
            "    \"count\": 10,\n" +
            "    \"limit\": 10,\n" +
            "    \"offset\": 0,\n" +
            "    \"results\": [],\n" +
            "    \"total\": 1564\n" +
            "  },\n" +
            "  \"status\": \"Ok\"\n" +
            "}"




    val listCharacterData = "[{\"description\":\"\",\"id\":1011334,\"name\":\"3-D Man\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011334\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg\",\"total\":1564},{\"description\":\"Rick Jones has been Hulk\\u0027s best bud since day one, but now he\\u0027s more than a friend...he\\u0027s a teammate! Transformed by a Gamma energy explosion, A-Bomb\\u0027s thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\"id\":1017100,\"name\":\"A-Bomb (HAS)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1017100\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg\",\"total\":1564},{\"description\":\"AIM is a terrorist organization bent on destroying the world.\",\"id\":1009144,\"name\":\"A.I.M.\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009144\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1010699,\"name\":\"Aaron Stack\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1010699\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564},{\"description\":\"Formerly known as Emil Blonsky, a spy of Soviet Yugoslavian origin working for the KGB, the Abomination gained his powers after receiving a dose of gamma radiation similar to that which transformed Bruce Banner into the incredible Hulk.\",\"id\":1009146,\"name\":\"Abomination (Emil Blonsky)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009146\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1016823,\"name\":\"Abomination (Ultimate)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1016823\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1009148,\"name\":\"Absorbing Man\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009148\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1009149,\"name\":\"Abyss\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009149\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1010903,\"name\":\"Abyss (Age of Apocalypse)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1010903\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/80/4c00358ec7548.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1011266,\"name\":\"Adam Destine\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011266\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564}]"



    fun getCharactersResponse(): CharactersResponse = serializeArticleData(data)

    fun getMarvelCharactersList() = listCharacterData.jsonParse<List<MarvelCharacter>>()



}