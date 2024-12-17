package com.example.home.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.sharedData.MarvelCharacter
import com.example.core.ui.component.AppLoading
import com.example.core.ui.component.ViewStateMessage
import com.example.core.ui.component.scaffold.MarvelScaffold
import com.example.home.presentation.components.CharacterCardItem
import com.example.utils.core.UiState
import com.example.utils.core.toJsonString


@Composable
internal fun HomeScreenRoute(
    onCharacterClick: (String) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val resultUiState by homeViewModel.resultUiState.collectAsStateWithLifecycle()
    val listState = homeViewModel.listState


    HomeScreen(
        onCharacterClick = onCharacterClick,
        lazyListState = listState,
        resultUiState = resultUiState,
        onLoadNext = homeViewModel::loadNextPage,
    )
}

@Composable
internal fun HomeScreen(
    onCharacterClick: (String) -> Unit,
    lazyListState: LazyListState,
    resultUiState: UiState<List<MarvelCharacter>?>,
    onLoadNext: (Int, Int, LazyListState) -> Unit,
) {

    val marvelCharactersList = remember { mutableStateListOf<MarvelCharacter>() }

    MarvelScaffold(
        title = "Marvel Characters",
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                when (resultUiState) {
                    is UiState.Error -> {
                        ViewStateMessage("can't find any result")
                    }

                    is UiState.Ideal -> {
                        if (marvelCharactersList.isNotEmpty()) {
                            MarvelCharacterResultView(
                                onCharacterClick = onCharacterClick,
                                lazyListState = lazyListState,
                                charactersList = marvelCharactersList,
                                onLoadNext = onLoadNext
                            )

                        }
                    }
                    is UiState.Loading -> {
                        MarvelCharacterResultView(
                            onCharacterClick = onCharacterClick,
                            lazyListState = lazyListState,
                            charactersList = marvelCharactersList,
                            onLoadNext = onLoadNext
                        )
                        AppLoading(resultUiState.isLoading)
                    }

                    is UiState.Success -> {
                        if (resultUiState.data.isNullOrEmpty()) {
                            ViewStateMessage("can't find any result")
                        } else {
                            marvelCharactersList.addAll(resultUiState.data!!)
                            MarvelCharacterResultView(
                                onCharacterClick = onCharacterClick,
                                lazyListState = lazyListState,
                                charactersList = marvelCharactersList,
                                onLoadNext = onLoadNext
                            )

                        }
                    }

                    is UiState.Start -> {}
                }

            }


        },

        )


}

@Composable
internal fun MarvelCharacterResultView(
    onCharacterClick: (String) -> Unit,
    lazyListState: LazyListState,
    charactersList: List<MarvelCharacter>,
    onLoadNext: (Int, Int, LazyListState) -> Unit
) {

    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .collect { lastVisibleIndex ->
                if (lastVisibleIndex != null && lastVisibleIndex >= charactersList.size - 1) {
                    onLoadNext(charactersList.first().total, charactersList.size, lazyListState)
                }
            }
    }

    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(items = charactersList) { character ->
            CharacterCardItem(marvelCharacter = character, openDetails = {
                onCharacterClick(it.toJsonString())
            })
        }
    }
}

