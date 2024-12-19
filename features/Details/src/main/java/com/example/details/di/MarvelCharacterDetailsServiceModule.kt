package com.example.details.di


import com.example.details.data.remote.service.details.MarvelCharacterDetailsService
import com.example.details.data.remote.service.details.MarvelCharacterDetailsServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(ViewModelComponent::class)
object MarvelCharacterDetailsServiceModule {

    @Provides
    fun provideMarvelCharacterDetailsService(httpClient: HttpClient): MarvelCharacterDetailsService {
        return MarvelCharacterDetailsServiceImpl(httpClient)
    }

}