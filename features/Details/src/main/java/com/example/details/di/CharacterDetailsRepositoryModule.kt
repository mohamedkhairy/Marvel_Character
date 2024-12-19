package com.example.details.di

import com.example.details.data.mapper.CharacterDetailsMapper
import com.example.details.data.mapper.CharacterResourcesMapper
import com.example.details.data.remote.service.details.MarvelCharacterDetailsService
import com.example.details.data.repository.CharacterDetailsRepositoryImp
import com.example.details.domain.repository.CharacterDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CharacterDetailsRepositoryModule {

    @Provides
    fun provideMarvelCharactersRepository(
        service: MarvelCharacterDetailsService,
        characterDetailsMapper: CharacterDetailsMapper,
        characterResourcesMapper: CharacterResourcesMapper
    ): CharacterDetailsRepository =
        CharacterDetailsRepositoryImp(service, characterDetailsMapper, characterResourcesMapper)

}
