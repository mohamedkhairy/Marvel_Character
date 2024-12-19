package com.example.home.presentation

import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import com.example.core.sharedData.MarvelCharacter
import com.example.home.presentation.screens.HomeScreenRoute
import com.example.home.utils.MarvelTestBase
import com.example.utils.core.UiState
import com.example.utils.core.toJsonString
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test


@HiltAndroidTest
class HomeScreenTest : MarvelTestBase() {




    @Test
    fun homeScreen_showsLoadingState() {
        with(composeTestRule) {
            // Given the ViewModel is in the loading state
            fakeViewModel.setResultUiState(UiState.Loading(isLoading = true))

            // When the HomeScreenRoute is displayed
            setContent {
                HomeScreenRoute(onCharacterClick = {}, homeViewModel = fakeViewModel)
            }

            // Then the loading UI is displayed
            onNodeWithTag("loading").assertExists()
        }
    }

    @Test
    fun homeScreen_showsEmptyState_whenNoCharacters() {
        with(composeTestRule) {
            // Given the ViewModel returns an empty list
            fakeViewModel.setResultUiState(UiState.Success(emptyList()))

            // When the HomeScreenRoute is displayed
            setContent {
                HomeScreenRoute(onCharacterClick = {}, homeViewModel = fakeViewModel)
            }

            // Then the empty state message is displayed
            onNodeWithText("can't find any result").assertExists()
        }
    }

    @Test
    fun homeScreen_displaysCharacters_whenDataIsAvailable() {
        with(composeTestRule) {

            // Given the ViewModel returns a list of characters
            val characters = listOf(
                MarvelCharacter(
                    total = 20,
                    id = 550,
                    name = "Spider Man",
                    thumbnail = "thumbnail",
                    description = "description",
                    resourceURI = "resourceURI",
                    characterResources = emptyList()
                ),
                MarvelCharacter(
                    total = 20,
                    id = 1100,
                    name = "Iron Man",
                    thumbnail = "thumbnail1",
                    description = "description1",
                    resourceURI = "resourceURI1",
                    characterResources = emptyList()
                ),
            )
            fakeViewModel.setResultUiState(UiState.Success(characters))

            // When the HomeScreenRoute is displayed
            setContent {
                HomeScreenRoute(onCharacterClick = {}, homeViewModel = fakeViewModel)
            }

            // Then the characters are displayed in the list
            onNodeWithTag("Spider Man").assertExists()
            onNodeWithTag("Iron Man").assertExists()
        }
    }

    @Test
    fun homeScreen_triggersPagination_whenScrolledToEnd() {
        with(composeTestRule) {

            // Given the ViewModel has some initial data
            val characters = List(4) { index ->
                MarvelCharacter(
                    total = 20,
                    id = index,
                    name = "Character $index",
                    thumbnail = "thumbnail1",
                    description = "description1",
                    resourceURI = "resourceURI1",
                    characterResources = emptyList()
                )
            }
            fakeViewModel.setResultUiState(UiState.Success(characters))

            // When the HomeScreenRoute is displayed
            setContent {
                HomeScreenRoute(onCharacterClick = {}, homeViewModel = fakeViewModel)
            }

            // Scroll to the end of the list
            onNodeWithTag("Character 3").assertExists()

            onNodeWithTag("Character 3").performScrollTo()

            // Wait for pagination to trigger
            waitForIdle()

            // Then pagination is triggered in the ViewModel
            assert(fakeViewModel.loadNextPageCalled)
        }
    }

    @Test
    fun homeScreen_showsErrorState_whenErrorOccurs() {
        with(composeTestRule) {

            // Given the ViewModel is in the error state
            fakeViewModel.setResultUiState(UiState.Error())

            // When the HomeScreenRoute is displayed
            setContent {
                HomeScreenRoute(onCharacterClick = {}, homeViewModel = fakeViewModel)
            }

            // Then the error message is displayed
            onNodeWithText("can't find any result").assertExists()
        }
    }

    @Test
    fun homeScreen_callsOnCharacterClick_whenCharacterIsClicked() {
        with(composeTestRule) {
            // Given the ViewModel returns a list of characters
            val characters = listOf(
                MarvelCharacter(
                    total = 20,
                    id = 550,
                    name = "Spider Man",
                    thumbnail = "thumbnail",
                    description = "description",
                    resourceURI = "resourceURI",
                    characterResources = emptyList()
                ),
            )

            fakeViewModel.setResultUiState(UiState.Success(characters))

            var clickedCharacterId: String? = null

            // When the HomeScreenRoute is displayed and a character is clicked
            setContent {
                HomeScreenRoute(
                    onCharacterClick = {
                        clickedCharacterId = it
                        assert(clickedCharacterId == characters.first().toJsonString())
                    },
                    homeViewModel = fakeViewModel
                )
            }

            onNodeWithTag("Spider Man").performClick()
            waitForIdle()
        }
    }
}
