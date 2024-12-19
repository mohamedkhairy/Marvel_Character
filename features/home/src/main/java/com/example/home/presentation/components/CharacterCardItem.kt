package com.example.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.sharedData.MarvelCharacter
import com.example.core.ui.component.CoilImagePainter

@Composable
fun CharacterCardItem(
    marvelCharacter: MarvelCharacter,
    openDetails: (MarvelCharacter) -> Unit
) {

    Card(
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { openDetails(marvelCharacter) }
    ) {

        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        )
        {

            Image(
                painter = CoilImagePainter(imageUrl = marvelCharacter.thumbnail),
                contentDescription = "character image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Row (
                Modifier.padding(16.dp),
            ){

                TextWithShape(value = marvelCharacter.name)

            }


        }
    }
}

@Composable
fun TextWithShape(value: String) {
    Surface(
        color = Color.White, // Background color
        shape = RoundedCornerShape(
            topStart = 5.dp,
            topEnd = 50.dp,
            bottomStart = 50.dp,
            bottomEnd = 5.dp), // Apply rounded corners
        shadowElevation = 4.dp, // Optional: Elevation for shadow
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 34.dp, vertical = 8.dp),
            text = value,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 8.sp,
            maxLines = 1,
            fontStyle = MaterialTheme.typography.titleMedium.fontStyle,
        )
    }
}