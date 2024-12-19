package com.example.details.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.sharedData.CharacterDetails
import com.example.core.ui.component.AppLoading
import com.example.core.ui.component.CoilImagePainter
import com.example.core.ui.component.ViewStateMessage
import com.example.utils.core.UiState
import com.example.utils.core.isNotNull

@Composable
fun CharacterDetailState(
    uiState: UiState<CharacterDetails?>
) {
    when (uiState) {
        is UiState.Error -> {
            ViewStateMessage("can't find any result")
        }

        is UiState.Ideal -> {
        }
        is UiState.Loading -> {
            AppLoading(uiState.isLoading)
        }

        is UiState.Success -> {
            if (uiState.data.isNotNull()){
                CharacterDetailView(characterDetails = uiState.data!!)
            } else{
                ViewStateMessage("can't find any result")
            }
        }

        is UiState.Start -> {}
    }
}

@Composable
private fun CharacterDetailView(characterDetails: CharacterDetails) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        Image(
            painter = CoilImagePainter(characterDetails.image),
            contentDescription = "Header Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )

        // Details Section
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Name
            Text(
                text = "NAME",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Text(
                text = characterDetails.name,
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Description
            Text(
                text = "DESCRIPTION",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
            Text(
                text = characterDetails.description ?: "--",
                color = Color.DarkGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }
    }
}