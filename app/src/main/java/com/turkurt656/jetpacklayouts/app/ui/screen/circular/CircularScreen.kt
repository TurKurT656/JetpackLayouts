package com.turkurt656.jetpacklayouts.app.ui.screen.circular

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CircularScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        OnlyRadiusCircular()
        Spacer(modifier = Modifier.size(8.dp))
        RadiusAngleCircular()
        Spacer(modifier = Modifier.size(8.dp))
        ExtraRadiusHexaCircular()
        Spacer(modifier = Modifier.size(8.dp))
        ExtraRadiusSpiralCircular()
        Spacer(modifier = Modifier.size(8.dp))
        ExactAngleCircular()
        Spacer(modifier = Modifier.size(16.dp))
    }
}