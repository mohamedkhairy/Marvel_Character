package com.example.home.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.sharedData.CharacterDetails
import com.example.core.sharedData.CharacterResources
import com.example.core.sharedData.ResourcesData
import com.example.details.domain.useCase.CharacterDetailsUseCase
import com.example.details.domain.useCase.ResourceDataUseCase
import com.example.utils.core.ActionState
import com.example.utils.core.UiState
import com.example.utils.core.isNotNull
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val characterDetailsUseCase: CharacterDetailsUseCase,
    private val resourceDataUseCase: ResourceDataUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val characterIdState = savedStateHandle.getStateFlow(key = CHARACTERS_ID, initialValue = 0)
    val resourcesState = savedStateHandle.getStateFlow(key = RESOURCES_LIST, initialValue = listOf<CharacterResources>())
    var actionState by mutableStateOf<ActionState>(ActionState.Close)

    val detailsUiState: StateFlow<UiState<CharacterDetails?>> =
        characterIdState.flatMapLatest { id ->
                if (id <= 0) {
                    flowOf(UiState.Ideal())
                } else {
                    characterDetailsUseCase(id)
                }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Start(),
        )

    val resourcesUiState: StateFlow<UiState<List<ResourcesData?>>> =
        resourcesState.flatMapLatest {
            if (it.isNotNull())
                resourceDataUseCase(it)
            else
                flowOf(UiState.Ideal())

        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Start(),
        )

    fun saveCharacterId(characterId: Int) {
        savedStateHandle[CHARACTERS_ID] = characterId
    }
    fun saveResourcesList(resourcesList: List<CharacterResources?>) {
        savedStateHandle[RESOURCES_LIST] = resourcesList
    }
    fun onActionStateChanged(actionState: ActionState) {
        this.actionState = actionState
    }

    companion object{
        private const val CHARACTERS_ID = "CHARACTERS_ID"
        private const val RESOURCES_LIST = "RESOURCES_LIST"
        private const val ACTION = "action_state"
    }
}
