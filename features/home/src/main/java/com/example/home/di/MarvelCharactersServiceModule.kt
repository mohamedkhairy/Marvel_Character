package com.example.home.di


import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.data.remote.service.characters.MarvelCharactersServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(ViewModelComponent::class)
object MarvelCharactersServiceModule {

    @Provides
    fun provideCharactersService(httpClient: HttpClient): MarvelCharactersService {
        return MarvelCharactersServiceImpl(httpClient)
    }

}