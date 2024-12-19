package com.example.home.di

import com.example.home.data.mapper.CharactersMapper
import com.example.home.data.remote.service.characters.MarvelCharactersService
import com.example.home.data.repository.MarvelCharactersRepositoryImp
import com.example.home.domain.repository.MarvelCharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MarvelCharactersRepositoryModule {

    @Provides
    fun provideMarvelCharactersRepository(
        service: MarvelCharactersService,
        charactersMapper: CharactersMapper,
    ): MarvelCharactersRepository =
        MarvelCharactersRepositoryImp(service, charactersMapper)

}
