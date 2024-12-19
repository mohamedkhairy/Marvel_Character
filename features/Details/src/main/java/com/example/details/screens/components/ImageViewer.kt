package com.example.details.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.core.ui.component.CoilImagePainter
import com.example.utils.core.ActionState

@Composable
fun ImageViewer(
    imageUrl: String,
    openImage: (ActionState) -> Unit
) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .clickable { openImage(ActionState.Close) }
        ) {
            Image(
                painter = CoilImagePainter(imageUrl),
                contentDescription = "Zoomable Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(600.dp)
                    .padding(20.dp)
            )
        }

}
