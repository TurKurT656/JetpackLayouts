package com.turkurt656.jetpacklayouts.circular

import androidx.compose.foundation.layout.LayoutScopeMarker
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@LayoutScopeMarker
@Immutable
interface CircularScope {
    @Stable
    fun Modifier.extraRadius(radius: Dp): Modifier
}

internal object CircularScopeInstance : CircularScope {
    @Stable
    override fun Modifier.extraRadius(radius: Dp): Modifier =
        then(ExtraRadius(radius))
}