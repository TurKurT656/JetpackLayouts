package com.turkurt656.jetpacklayouts.app.ui.screen.circular

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.turkurt656.jetpacklayouts.app.NavigateButton

@Composable
fun CircularScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavigateButton(text = "Only Radius", route = "o-r-circular")
        NavigateButton(text = "Radius Angle", route = "r-a-circular")
        NavigateButton(text = "Extra Radius Hexa", route = "e-r-h-circular")
        NavigateButton(text = "Extra Radius Spiral", route = "e-r-s-circular")
        NavigateButton(text = "Exact Angle", route = "e-a-circular")
    }
}