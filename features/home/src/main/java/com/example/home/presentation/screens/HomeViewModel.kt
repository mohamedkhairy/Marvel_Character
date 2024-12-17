package com.example.home.presentation.screens

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.sharedData.MarvelCharacter
import com.example.home.domain.useCase.MarvelCharactersUseCase
import com.example.utils.core.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val marvelCharactersUseCase: MarvelCharactersUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {


    var listState: LazyListState by mutableStateOf(LazyListState(0, 0))

    val offsetState = savedStateHandle.getStateFlow(key = OFFSET, initialValue = 0)

    private var offset = 0
    private var total = 10
    private var isLoading = mutableStateOf(false)
    private var hasMoreData = mutableStateOf(true)


    val resultUiState: StateFlow<UiState<List<MarvelCharacter>?>> =
        offsetState.flatMapLatest { offset ->
            if (!isLoading.value || hasMoreData.value) {
                if (offset >= total) {
                    hasMoreData.value = false
                    flowOf(UiState.Success())
                } else {
                    hasMoreData.value = true
                    marvelCharactersUseCase(offset)
                }
            } else {
                flowOf(UiState.Ideal())
            }
        }.onCompletion {
            isLoading.value = false
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Start(),
        )

    fun loadNextPage(
        total: Int, newItemsCount: Int, lazyListState: LazyListState
    ) {
        this.offset += newItemsCount
        this.total = total
        savedStateHandle[OFFSET] = offset
        listState = lazyListState
    }
}

private const val OFFSET = "offset"
