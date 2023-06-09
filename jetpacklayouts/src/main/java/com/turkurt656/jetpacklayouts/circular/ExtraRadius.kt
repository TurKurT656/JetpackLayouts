package com.turkurt656.jetpacklayouts.circular

import androidx.compose.runtime.Immutable
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

@JvmInline
@Immutable
internal value class ExtraRadius(
    private val radius: Dp
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) =
        ((parentData as? CircularParentData) ?: CircularParentData()).apply {
            extraRadius = radius
        }
}