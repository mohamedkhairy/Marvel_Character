package com.example.home.presentation

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.core.sharedData.MarvelCharacter
import com.example.home.domain.useCase.MarvelCharactersUseCase
import com.example.home.presentation.screens.HomeViewModel
import com.example.home.utils.Constant.OFFSET
import com.example.utils.core.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var mockMarvelCharactersUseCase: MarvelCharactersUseCase
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var homeViewModel: HomeViewModel
    val characters = listOf(
        MarvelCharacter(total = 20, id = 550, name = "Spider Man", thumbnail = "thumbnail", description = "description", resourceURI = "resourceURI" , characterResources = emptyList()),
        MarvelCharacter(total = 20, id = 1100, name = "Iron Man", thumbnail = "thumbnail1", description = "description1", resourceURI = "resourceURI1", characterResources = emptyList()),
        MarvelCharacter(total = 20, id = 1101, name = "Captain America", thumbnail = "thumbnail2", description = "description2", resourceURI = "resourceURI2", characterResources = emptyList())
    )

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        mockMarvelCharactersUseCase = mock()
        savedStateHandle = SavedStateHandle()
        homeViewModel = HomeViewModel(mockMarvelCharactersUseCase, savedStateHandle)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state should be loading state`() = runTest {
        homeViewModel.resultUiState.test {
            assertEquals(UiState.Start<List<MarvelCharacter>>(), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `loadNextPage should update offset and state correctly`() {
        val lazyListState = LazyListState(0, 0)

        homeViewModel.loadNextPage(total = 20, newItemsCount = 10, lazyListState = lazyListState)

        assertEquals(10, savedStateHandle.get<Int>(OFFSET))
        assertEquals(lazyListState, homeViewModel.listState)
    }

    @Test
    fun `when offset is less than total, should fetch new characters from api`() = runTest {
        whenever(mockMarvelCharactersUseCase(any())).thenReturn(flowOf(UiState.Success(characters)))

        savedStateHandle[OFFSET] = 0
        homeViewModel.resultUiState.test {
            assertEquals(UiState.Start<List<MarvelCharacter>>(), awaitItem())
            assertEquals(UiState.Success(characters), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `when offset is greater than or equal to total, should update hasMoreData to false and return Ideal state`() = runTest {
        whenever(mockMarvelCharactersUseCase(any())).thenReturn(flowOf(UiState.Success(characters)))

        homeViewModel.loadNextPage(total = 10, newItemsCount = 10, lazyListState = LazyListState(0, 0))
        savedStateHandle[OFFSET] = 10 // Set offset to total
        homeViewModel.resultUiState.test {
            assertEquals(UiState.Start<List<MarvelCharacter>>(), awaitItem())
            assertEquals(UiState.Ideal<MarvelCharacter>(), awaitItem()) // Should return Success with no data
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `when isLoading is true, should return Ideal state`() = runTest {
        whenever(mockMarvelCharactersUseCase(any())).thenReturn(flowOf(UiState.Success(characters)))

        homeViewModel.loadNextPage(total = 20, newItemsCount = 10, lazyListState = LazyListState(0, 0))
        homeViewModel.loadNextPage(total = 20, newItemsCount = 10, lazyListState = LazyListState(0, 0)) // Trigger loading again

        homeViewModel.resultUiState.test {
            assertEquals(UiState.Start<List<MarvelCharacter>>(), awaitItem())
            assertEquals(UiState.Ideal<List<MarvelCharacter>?>(), awaitItem())
            cancelAndConsumeRemainingEvents()
        }
    }
}