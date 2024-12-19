package com.example.details.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.sharedData.ResourcesData
import com.example.core.sharedData.ResourcesPair
import com.example.core.ui.component.CoilImagePainter
import com.example.core.ui.component.ViewStateMessage
import com.example.utils.core.ActionState
import com.example.utils.core.UiState

@Composable
fun ResourcesState(
    uiState: UiState<List<ResourcesData?>>,
    openImage: (ActionState) -> Unit
) {
    val resourcesRemember = remember { mutableStateListOf<ResourcesData?>() }

    when (uiState) {
        is UiState.Error -> {
            uiState.throwable?.printStackTrace()
            uiState.throwable?.message

            if (resourcesRemember.isEmpty())
                ViewStateMessage("can't find any result")
        }

        is UiState.Ideal -> {

        }

        is UiState.Loading -> {
//            AppLoading(uiState.isLoading)
        }

        is UiState.Success -> {
            if (uiState.data.isNullOrEmpty().not()) {
                resourcesRemember.addAll(uiState.data!!)
                ResourcesView(
                    resources = resourcesRemember,
                    openImage = openImage
                )
            } else {
                ViewStateMessage("can't find any result")
            }
        }

        is UiState.Start -> {}
    }
}

@Composable
private fun ResourcesView(
    resources: List<ResourcesData?>,
    openImage: (ActionState) -> Unit
) {
    resources.forEach {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {

            it?.let { resList ->
                // Comics Section
                Text(
                    text = resList.resourceKey.key,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Horizontal Lazy Row for Comics
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(resList.pairList) { data ->
                        ComicItem(
                            resourcesData = data,
                            openImage = openImage
                        )
                    }
                }

            }
        }
    }
}


@Composable
fun ComicItem(
    resourcesData: ResourcesPair,
    openImage: (ActionState) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                resourcesData.image?.let {
                    openImage(ActionState.Open(it))
                }
            }
            .width(120.dp)
    ) {
        Image(
            painter = CoilImagePainter(resourcesData.thumbnail),
            contentDescription = resourcesData.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(160.dp)
                .clip(RoundedCornerShape(8.dp))

        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = resourcesData.title,
            color = Color.DarkGray,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }

}

