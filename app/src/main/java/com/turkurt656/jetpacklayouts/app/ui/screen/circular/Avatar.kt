package com.turkurt656.jetpacklayouts.app.ui.screen.circular

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.turkurt656.jetpacklayouts.modifier.bounceClickable

@Composable
fun CenterAvatar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    AsyncImage(
        modifier = modifier
            .size(160.dp)
            .bounceClickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = "https://i.pravatar.cc/300?u=${imageIds[0]}",
        contentDescription = null
    )
}

@Composable
fun ChildAvatar(
    modifier: Modifier = Modifier,
    imageId: String,
) {
    AsyncImage(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        model = "https://i.pravatar.cc/300?u=$imageId",
        contentDescription = null
    )
}