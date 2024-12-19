package com.example.details.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.sharedData.CharacterDetails
import com.example.core.sharedData.MarvelCharacter
import com.example.core.sharedData.ResourcesData
import com.example.core.ui.component.scaffold.MarvelScaffold
import com.example.details.screens.components.CharacterDetailState
import com.example.details.screens.components.ImageViewer
import com.example.details.screens.components.ResourcesState
import com.example.home.presentation.screens.DetailsViewModel
import com.example.utils.core.ActionState
import com.example.utils.core.UiState
import kotlinx.coroutines.launch


@Composable
internal fun DetailsRoute(
    marvelCharacter: MarvelCharacter?,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
) {
    marvelCharacter?.let {

        val resourcesRemember = remember { mutableStateOf(it.characterResources) }
        val idRemember = remember { mutableIntStateOf(it.id) }

        val detailsUiState by detailsViewModel.detailsUiState.collectAsStateWithLifecycle()
        val resourceState by detailsViewModel.resourcesUiState.collectAsStateWithLifecycle()

        detailsViewModel.saveCharacterId(idRemember.intValue)
        detailsViewModel.saveResourcesList(resourcesRemember.value)

        ArticleDetailsScreen(
            marvelCharacter = marvelCharacter,
            detailsUiState = detailsUiState,
            resourceState = resourceState,
            actionState = detailsViewModel.actionState,
            openImage = detailsViewModel::onActionStateChanged
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ArticleDetailsScreen(
    marvelCharacter: MarvelCharacter?,
    detailsUiState: UiState<CharacterDetails?>,
    resourceState: UiState<List<ResourcesData?>>,
    actionState: ActionState,
    openImage: (ActionState) -> Unit
) {

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    MarvelScaffold(
        title = marvelCharacter?.name ?: "Marvel",
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(scrollState)
            ) {
                Box(contentAlignment = Alignment.TopCenter) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        CharacterDetailState(uiState = detailsUiState)
                        ResourcesState(
                            uiState = resourceState,
                            openImage = openImage
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        when (actionState) {
                            ActionState.Close -> {}
                            is ActionState.Open -> {
                                coroutineScope.launch {
                                    scrollState.animateScrollTo(0)
                                }
                                ImageViewer(actionState.url, openImage)
                            }
                        }
                    }
                }
            }
        }
    )

}





