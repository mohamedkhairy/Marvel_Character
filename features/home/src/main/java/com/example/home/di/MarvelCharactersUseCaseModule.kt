package com.example.home.di

import com.example.core.sharedData.MarvelCharacter
import com.example.home.domain.useCase.MarvelCharactersUseCase
import com.example.utils.usecases.FlowUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MarvelCharactersUseCaseModule {


    @Singleton
    @Binds
    abstract fun bindMarvelCharactersUseCase(marvelCharactersUseCase: MarvelCharactersUseCase): FlowUseCase<Int, List<MarvelCharacter>?>


}