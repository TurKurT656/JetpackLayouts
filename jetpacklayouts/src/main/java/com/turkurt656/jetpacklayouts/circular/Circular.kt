package com.turkurt656.jetpacklayouts.circular


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MultiContentMeasurePolicy
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

@Composable
fun Circular(
    modifier: Modifier = Modifier,
    overrideRadius: (() -> Dp)? = null,
    startAngle: () -> Float = { 0.0f },
    center: @Composable () -> Unit,
    content: @Composable CircularScope.() -> Unit,
) {
    Layout(
        measurePolicy = circularMeasurePolicy(overrideRadius, startAngle),
        contents = listOf(center, { CircularScopeInstance.content() }),
        modifier = modifier,
    )
}

private fun circularMeasurePolicy(
    overrideRadius: (() -> Dp)?,
    startAngle: () -> Float,
) =
    MultiContentMeasurePolicy { (centerMeasurables: List<Measurable>, contentMeasurables: List<Measurable>),
                                constraints: Constraints ->

        require(centerMeasurables.size == 1) { "Center composable can have only one child" }

        // Measure children
        val modifiedConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val centerPlaceable: Placeable = centerMeasurables.first().measure(modifiedConstraints)
        val contentPlaceables: List<Placeable> = contentMeasurables.map { it.measure(modifiedConstraints) }

        require(centerPlaceable.isCircle()) { "Center composable must be circle" }
        require(contentPlaceables.all { it.isCircle() }) { "Content composables must be circle" }

        // Calculate layout size
        val overallRadius = overrideRadius?.invoke()?.roundToPx() ?: (centerPlaceable.height / 2)
        val maxExtraRadius = contentPlaceables.mapNotNull { placeable ->
            (placeable.parentData as? CircularParentData)?.extraRadius?.roundToPx()
        }.maxOrNull() ?: 0
        val totalRadius = overallRadius + maxExtraRadius
        val biggestChildSize = contentPlaceables.maxOfOrNull { it.height } ?: 0
        val centerSize = centerPlaceable.height
        val layoutSize = max(centerSize, 2 * totalRadius + biggestChildSize)

        layout(layoutSize, layoutSize) {
            // Place children
            val angleBetweenChildren = 360.0f / contentPlaceables.size
            val middle = layoutSize / 2
            var angle = startAngle()
            contentPlaceables.forEach { placeable ->
                val finalAngle = (placeable.parentData as? CircularParentData)?.exactAngle ?: angle
                val angleRadian = finalAngle * Math.PI / 180
                val radius =
                    overallRadius + ((placeable.parentData as? CircularParentData)?.extraRadius?.roundToPx()
                        ?: 0)
                placeable.place(
                    x = (middle + radius * sin(angleRadian) - placeable.height / 2).toInt(),
                    y = (middle - radius * cos(angleRadian) - placeable.height / 2).toInt(),
                )
                angle += angleBetweenChildren
            }
            centerPlaceable.place(middle - centerSize / 2, middle - centerSize / 2)
        }
    }

private fun Placeable.isCircle() = height == width
