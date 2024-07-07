package com.turkurt656.jetpacklayouts.app.ui.screen.circular

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.circularGraph() {
    composable("circular") { CircularScreen() }
    composable("e-a-circular") { ExactAngleCircular() }
    composable("e-r-h-circular") { ExtraRadiusHexaCircular() }
    composable("e-r-s-circular") { ExtraRadiusSpiralCircular() }
    composable("o-r-circular") { OnlyRadiusCircular() }
    composable("r-a-circular") { RadiusAngleCircular() }
}