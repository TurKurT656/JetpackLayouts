package com.turkurt656.jetpacklayouts.app.ui.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role

fun Modifier.bounceClickable(
    scaleDown: Float = 0.9f,
    animationSpec: AnimationSpec<Float> = spring(
        Spring.DampingRatioHighBouncy,
        stiffness = Spring.StiffnessLow,
    ),
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
) = this.composed(
    inspectorInfo = debugInspectorInfo {
        name = "bounceClickable"
        properties["scaleDown"] = scaleDown
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {
    Modifier.bounceClickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = LocalIndication.current,
        scaleDown = scaleDown,
        animationSpec = animationSpec,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick
    )
}

fun Modifier.bounceClickable(
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    scaleDown: Float = 0.9f,
    animationSpec: AnimationSpec<Float> = spring(
        Spring.DampingRatioHighBouncy,
        stiffness = Spring.StiffnessLow,
    ),
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
) = this.composed(
    inspectorInfo = debugInspectorInfo {
        name = "bounceClickable"
        properties["interactionSource"] = interactionSource
        properties["indication"] = indication
        properties["scaleDown"] = scaleDown
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {

    val isPressed by interactionSource.collectIsPressedAsState()

    val animatable = remember {
        Animatable(1f)
    }

    LaunchedEffect(key1 = isPressed) {
        if (isPressed) animatable.animateTo(scaleDown, animationSpec)
        else animatable.animateTo(1f, animationSpec)
    }

    Modifier
        .graphicsLayer {
            val scale = animatable.value
            scaleX = scale
            scaleY = scale
        }
        .clickable(
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClick
        )
}
