package com.example.home.fakeData

import com.example.core.sharedData.MarvelCharacter
import com.example.home.data.remote.dto.CharactersResponse
import com.example.home.serializeArticleData
import com.example.utils.core.jsonParse

object MarvelCharactersValid {

    val data = "{\n" +
            "   \"code\":200,\n" +
            "   \"status\":\"Ok\",\n" +
            "   \"etag\":\"55af6142849a32791ad5decca2639465ca17c5c7\",\n" +
            "   \"data\":{\n" +
            "      \"offset\":0,\n" +
            "      \"limit\":2,\n" +
            "      \"total\":1564,\n" +
            "      \"count\":2,\n" +
            "      \"results\":[\n" +
            "         {\n" +
            "            \"id\":1011334,\n" +
            "            \"name\":\"3-D Man\",\n" +
            "            \"description\":\"\",\n" +
            "            \"modified\":\"2014-04-29T14:18:17-0400\",\n" +
            "            \"thumbnail\":{\n" +
            "               \"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784\",\n" +
            "               \"extension\":\"jpg\"\n" +
            "            },\n" +
            "            \"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011334\",\n" +
            "            \"comics\":{\n" +
            "               \"available\":12,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/comics\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/21366\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #14\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/24571\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #14 (SPOTLIGHT VARIANT)\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/21546\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #15\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/21741\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #16\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/21975\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #17\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/22299\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #18\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/22300\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #18 (ZOMBIE VARIANT)\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/22506\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #19\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/8500\",\n" +
            "                     \"name\":\"Deadpool (1997) #44\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/10223\",\n" +
            "                     \"name\":\"Marvel Premiere (1972) #35\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/10224\",\n" +
            "                     \"name\":\"Marvel Premiere (1972) #36\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/10225\",\n" +
            "                     \"name\":\"Marvel Premiere (1972) #37\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":12\n" +
            "            },\n" +
            "            \"series\":{\n" +
            "               \"available\":3,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/series\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/1945\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007 - 2010)\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/2005\",\n" +
            "                     \"name\":\"Deadpool (1997 - 2002)\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/2045\",\n" +
            "                     \"name\":\"Marvel Premiere (1972 - 1981)\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":3\n" +
            "            },\n" +
            "            \"stories\":{\n" +
            "               \"available\":21,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/stories\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19947\",\n" +
            "                     \"name\":\"Cover #19947\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19948\",\n" +
            "                     \"name\":\"The 3-D Man!\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19949\",\n" +
            "                     \"name\":\"Cover #19949\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19950\",\n" +
            "                     \"name\":\"The Devil's Music!\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19951\",\n" +
            "                     \"name\":\"Cover #19951\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/19952\",\n" +
            "                     \"name\":\"Code-Name:  The Cold Warrior!\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/54371\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #14, Spotlight Variant - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47185\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #14 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47499\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #15 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47793\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #16 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/48362\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #17 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/49104\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #18 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/49106\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #18, Zombie Variant - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/49889\",\n" +
            "                     \"name\":\"Avengers: The Initiative (2007) #19 - Int\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/96303\",\n" +
            "                     \"name\":\"Deadpool (1997) #44\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47184\",\n" +
            "                     \"name\":\"AVENGERS: THE INITIATIVE (2007) #14\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47498\",\n" +
            "                     \"name\":\"AVENGERS: THE INITIATIVE (2007) #15\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/47792\",\n" +
            "                     \"name\":\"AVENGERS: THE INITIATIVE (2007) #16\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/48361\",\n" +
            "                     \"name\":\"AVENGERS: THE INITIATIVE (2007) #17\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/49103\",\n" +
            "                     \"name\":\"AVENGERS: THE INITIATIVE (2007) #18\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":20\n" +
            "            },\n" +
            "            \"events\":{\n" +
            "               \"available\":1,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/events\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/events/269\",\n" +
            "                     \"name\":\"Secret Invasion\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":1\n" +
            "            },\n" +
            "            \"urls\":[\n" +
            "               {\n" +
            "                  \"type\":\"detail\",\n" +
            "                  \"url\":\"http://marvel.com/characters/74/3-d_man?utm_campaign=apiRef&utm_source=437aef6206f1c8ab40f10e6fe6f90f69\"\n" +
            "               },\n" +
            "               {\n" +
            "                  \"type\":\"wiki\",\n" +
            "                  \"url\":\"http://marvel.com/universe/3-D_Man_(Chandler)?utm_campaign=apiRef&utm_source=437aef6206f1c8ab40f10e6fe6f90f69\"\n" +
            "               },\n" +
            "               {\n" +
            "                  \"type\":\"comiclink\",\n" +
            "                  \"url\":\"http://marvel.com/comics/characters/1011334/3-d_man?utm_campaign=apiRef&utm_source=437aef6206f1c8ab40f10e6fe6f90f69\"\n" +
            "               }\n" +
            "            ]\n" +
            "         },\n" +
            "         {\n" +
            "            \"id\":1017100,\n" +
            "            \"name\":\"A-Bomb (HAS)\",\n" +
            "            \"description\":\"Rick Jones has been Hulk's best bud since day one, but now he's more than a friend...he's a teammate! Transformed by a Gamma energy explosion, A-Bomb's thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\n" +
            "            \"modified\":\"2013-09-18T15:54:04-0400\",\n" +
            "            \"thumbnail\":{\n" +
            "               \"path\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16\",\n" +
            "               \"extension\":\"jpg\"\n" +
            "            },\n" +
            "            \"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1017100\",\n" +
            "            \"comics\":{\n" +
            "               \"available\":4,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/comics\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/47176\",\n" +
            "                     \"name\":\"FREE COMIC BOOK DAY 2013 1 (2013) #1\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40632\",\n" +
            "                     \"name\":\"Hulk (2008) #53\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40630\",\n" +
            "                     \"name\":\"Hulk (2008) #54\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/comics/40628\",\n" +
            "                     \"name\":\"Hulk (2008) #55\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":4\n" +
            "            },\n" +
            "            \"series\":{\n" +
            "               \"available\":2,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/series\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/17765\",\n" +
            "                     \"name\":\"FREE COMIC BOOK DAY 2013 1 (2013)\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/series/3374\",\n" +
            "                     \"name\":\"Hulk (2008 - 2012)\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":2\n" +
            "            },\n" +
            "            \"stories\":{\n" +
            "               \"available\":7,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/stories\",\n" +
            "               \"items\":[\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92086\",\n" +
            "                     \"name\":\"Hulk (2008) #53\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92087\",\n" +
            "                     \"name\":\"Interior #92087\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92082\",\n" +
            "                     \"name\":\"Hulk (2008) #54\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92083\",\n" +
            "                     \"name\":\"Interior #92083\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92078\",\n" +
            "                     \"name\":\"Hulk (2008) #55\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/92079\",\n" +
            "                     \"name\":\"Interior #92079\",\n" +
            "                     \"type\":\"interiorStory\"\n" +
            "                  },\n" +
            "                  {\n" +
            "                     \"resourceURI\":\"http://gateway.marvel.com/v1/public/stories/105929\",\n" +
            "                     \"name\":\"cover from Free Comic Book Day 2013 (Avengers/Hulk) (2013) #1\",\n" +
            "                     \"type\":\"cover\"\n" +
            "                  }\n" +
            "               ],\n" +
            "               \"returned\":7\n" +
            "            },\n" +
            "            \"events\":{\n" +
            "               \"available\":0,\n" +
            "               \"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/events\",\n" +
            "               \"items\":[\n" +
            "                  \n" +
            "               ],\n" +
            "               \"returned\":0\n" +
            "            },\n" +
            "            \"urls\":[\n" +
            "               {\n" +
            "                  \"type\":\"detail\",\n" +
            "                  \"url\":\"http://marvel.com/characters/76/a-bomb?utm_campaign=apiRef&utm_source=437aef6206f1c8ab40f10e6fe6f90f69\"\n" +
            "               },\n" +
            "               {\n" +
            "                  \"type\":\"comiclink\",\n" +
            "                  \"url\":\"http://marvel.com/comics/characters/1017100/a-bomb_has?utm_campaign=apiRef&utm_source=437aef6206f1c8ab40f10e6fe6f90f69\"\n" +
            "               }\n" +
            "            ]\n" +
            "         }\n" +
            "      ]\n" +
            "   }\n" +
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



    val listCharacterData = "[{\"characterResources\":[{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/comics\",\"resourceKey\":\"COMICS\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/events\",\"resourceKey\":\"EVENTS\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/series\",\"resourceKey\":\"SERIES\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1011334/stories\",\"resourceKey\":\"STORIES\"}],\"description\":\"\",\"id\":1011334,\"name\":\"3-D Man\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011334\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg\",\"total\":1564},{\"characterResources\":[{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/comics\",\"resourceKey\":\"COMICS\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/events\",\"resourceKey\":\"EVENTS\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/series\",\"resourceKey\":\"SERIES\"},{\"collectionURI\":\"http://gateway.marvel.com/v1/public/characters/1017100/stories\",\"resourceKey\":\"STORIES\"}],\"description\":\"Rick Jones has been Hulk\\u0027s best bud since day one, but now he\\u0027s more than a friend...he\\u0027s a teammate! Transformed by a Gamma energy explosion, A-Bomb\\u0027s thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\"id\":1017100,\"name\":\"A-Bomb (HAS)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1017100\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg\",\"total\":1564}]"
//    val listCharacterData = "[{\"description\":\"\",\"id\":1011334,\"name\":\"3-D Man\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011334\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg\",\"total\":1564},{\"description\":\"Rick Jones has been Hulk\\u0027s best bud since day one, but now he\\u0027s more than a friend...he\\u0027s a teammate! Transformed by a Gamma energy explosion, A-Bomb\\u0027s thick, armored skin is just as strong and powerful as it is blue. And when he curls into action, he uses it like a giant bowling ball of destruction! \",\"id\":1017100,\"name\":\"A-Bomb (HAS)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1017100\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16.jpg\",\"total\":1564},{\"description\":\"AIM is a terrorist organization bent on destroying the world.\",\"id\":1009144,\"name\":\"A.I.M.\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009144\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/6/20/52602f21f29ec.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1010699,\"name\":\"Aaron Stack\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1010699\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564},{\"description\":\"Formerly known as Emil Blonsky, a spy of Soviet Yugoslavian origin working for the KGB, the Abomination gained his powers after receiving a dose of gamma radiation similar to that which transformed Bruce Banner into the incredible Hulk.\",\"id\":1009146,\"name\":\"Abomination (Emil Blonsky)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009146\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/50/4ce18691cbf04.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1016823,\"name\":\"Abomination (Ultimate)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1016823\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1009148,\"name\":\"Absorbing Man\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009148\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/1/b0/5269678709fb7.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1009149,\"name\":\"Abyss\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1009149\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/9/30/535feab462a64.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1010903,\"name\":\"Abyss (Age of Apocalypse)\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1010903\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/3/80/4c00358ec7548.jpg\",\"total\":1564},{\"description\":\"\",\"id\":1011266,\"name\":\"Adam Destine\",\"resourceURI\":\"http://gateway.marvel.com/v1/public/characters/1011266\",\"thumbnail\":\"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg\",\"total\":1564}]"



    fun getCharactersResponse(): CharactersResponse = serializeArticleData(data)

    fun getMarvelCharactersList() = listCharacterData.jsonParse<List<MarvelCharacter>>()



}