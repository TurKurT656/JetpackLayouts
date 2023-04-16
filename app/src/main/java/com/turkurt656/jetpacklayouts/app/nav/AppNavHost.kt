package com.turkurt656.jetpacklayouts.app.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.turkurt656.jetpacklayouts.app.ui.screen.MainScreen
import com.turkurt656.jetpacklayouts.app.ui.screen.circular.CircularScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("circular") { CircularScreen(navController) }
    }
}