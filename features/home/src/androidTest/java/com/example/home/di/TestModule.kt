//package com.example.home.di
//
//import android.util.Log
//import com.example.core.sharedData.MarvelCharacter
//import com.example.home.domain.useCase.MarvelCharactersUseCase
//import com.example.home.utils.FakeData.charactersList
//import com.example.utils.core.UiState
//import com.example.utils.usecases.FlowUseCase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.android.components.ViewModelComponent
//import dagger.hilt.components.SingletonComponent
//import dagger.hilt.testing.TestInstallIn
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.runBlocking
//import org.mockito.Mockito
//import org.mockito.Mockito.mock
//
///**
// * TestModule provides mock implementations of use cases for testing, replacing the original `MarvelCharactersUseCaseModule`.
// * Installed in the ViewModelComponent, this module is used exclusively in tests.
// */
//
//@Module
//@TestInstallIn(
//    components = [SingletonComponent::class],
//    replaces = [MarvelCharactersUseCaseModule::class]
//)
//object TestModule {
//
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Provides
//    fun provideMarvelCharactersUseCase(): FlowUseCase<Int, List<MarvelCharacter>?> {
//        return mock(MarvelCharactersUseCase::class.java).apply {
//            runBlocking {
//                println("provideMarvelCharactersUseCase")
//                Mockito.`when`(invoke(10)).thenReturn(
//                    MutableStateFlow(
//                        UiState.Success(charactersList)
//                    )
//                )
//            }
//        }
//    }
//
//
//}
