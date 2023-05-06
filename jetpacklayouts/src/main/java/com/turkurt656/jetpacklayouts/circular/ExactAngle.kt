package com.turkurt656.jetpacklayouts.circular

import androidx.compose.runtime.Immutable
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.unit.Density

@JvmInline
@Immutable
internal value class ExactAngle(
    private val angle: Float
) : ParentDataModifier {
    override fun Density.modifyParentData(parentData: Any?) =
        ((parentData as? CircularParentData) ?: CircularParentData()).apply {
            exactAngle = angle
        }
}