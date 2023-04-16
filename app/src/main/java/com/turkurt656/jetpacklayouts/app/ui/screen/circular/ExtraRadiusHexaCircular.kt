package com.turkurt656.jetpacklayouts.app.ui.screen.circular

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turkurt656.jetpacklayouts.circular.Circular

@Composable
fun ExtraRadiusHexaCircular() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        var isExpanded by remember { mutableStateOf(false) }

        val radius by animateDpAsState(
            targetValue = if (isExpanded) 120.dp else 80.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessVeryLow,
            ),
        )

        val startAngle by animateFloatAsState(
            targetValue = if (isExpanded) 30f else 0f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessVeryLow,
            ),
        )

        Circular(
            overrideRadius = { radius },
            startAngle = { startAngle },
            center = {
                CenterAvatar { isExpanded = !isExpanded }
            }
        ) {
            for (i in 1..12) {
                ChildAvatar(
                    modifier = Modifier.extraRadius((if (i.mod(2) == 0) 0.dp else 16.dp)),
                    imageId = imageIds[i]
                )
            }
        }
    }
}