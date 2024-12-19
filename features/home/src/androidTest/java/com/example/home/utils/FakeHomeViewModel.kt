package com.example.home.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.lifecycle.SavedStateHandle
import com.example.core.sharedData.MarvelCharacter
import com.example.home.presentation.screens.HomeViewModel
import com.example.utils.core.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeHomeViewModel : HomeViewModel(
    marvelCharactersUseCase = FakeMarvelCharactersUseCase(),
    savedStateHandle = SavedStateHandle()
) {

    var loadNextPageCalled = false
    private val _resultUiState = MutableStateFlow<UiState<List<MarvelCharacter>?>>(UiState.Start())

    override val resultUiState: StateFlow<UiState<List<MarvelCharacter>?>> = _resultUiState

    fun setResultUiState(state: UiState<List<MarvelCharacter>?>) {
        _resultUiState.value = state
    }

    override fun loadNextPage(total: Int, newItemsCount: Int, lazyListState: LazyListState) {
        loadNextPageCalled = true
    }
}
