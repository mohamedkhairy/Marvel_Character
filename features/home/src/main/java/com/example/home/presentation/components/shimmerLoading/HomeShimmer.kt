package com.example.home.presentation.components.shimmerLoading

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeShimmer(){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(1)
    ) {
        items(count = 8){
            ShimmerArticleCardItem()
        }
    }
}