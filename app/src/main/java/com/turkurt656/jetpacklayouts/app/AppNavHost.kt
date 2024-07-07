package com.turkurt656.jetpacklayouts.app

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.turkurt656.jetpacklayouts.app.ui.screen.MainScreen
import com.turkurt656.jetpacklayouts.app.ui.screen.circular.circularGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    RememberNavController(navController = navController) {
        NavHost(navController, startDestination = "main") {
            composable("main") { MainScreen() }
            circularGraph()
        }
    }
}

@Composable
fun RememberNavController(
    navController: NavHostController,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalNavHostController provides navController, content = content)
}

val LocalNavHostController = staticCompositionLocalOf<NavHostController> {
    noLocalProvidedFor("LocalNavHostController")
}

@Suppress("SameParameterValue")
private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}

@Composable
fun NavigateButton(
    text: String,
    route: String,
) {
    val navController = LocalNavHostController.current
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            navController.navigate(route)
        }
    ) {
        Text(text = text)
    }
}