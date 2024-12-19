package com.example.details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.core.sharedData.MarvelCharacter
import com.example.details.screens.DetailsRoute
import com.example.utils.core.jsonParse

const val DETAILS_ROUTE_BASE = "details_route"

const val CHARACTER_DETAILS_ARG = "CHARACTER_DETAILS_ARG"

const val DETAILS_ROUTE = "$DETAILS_ROUTE_BASE?$CHARACTER_DETAILS_ARG={$CHARACTER_DETAILS_ARG}"

fun NavController.navigateToDetails(article: String?, navOptions: NavOptions? = null) {
    val route = if (!article.isNullOrEmpty()) {
        "${DETAILS_ROUTE_BASE}?${CHARACTER_DETAILS_ARG}=$article"
    } else {
        DETAILS_ROUTE_BASE
    }
    navigate(route, navOptions)
}


fun NavGraphBuilder.detailsScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = DETAILS_ROUTE,
        arguments = listOf(
            navArgument(CHARACTER_DETAILS_ARG) {
                type = NavType.StringType
            },
        ),
    ) {

        val marvelCharacter = it.arguments?.getString(CHARACTER_DETAILS_ARG)
        DetailsRoute(
            marvelCharacter = marvelCharacter?.jsonParse<MarvelCharacter>(),
        )
    }
}
