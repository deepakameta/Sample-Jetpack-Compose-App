package com.robustdev.samplecomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.robustdev.samplecomposeapp.screens.FirstScreen
import com.robustdev.samplecomposeapp.screens.SecondScreen

sealed class Screen(val route: String) {
    data object First : Screen("first_screen")
    data object Second : Screen("second_screen")
}

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.First.route,
    ) {

        composable(Screen.First.route) {
            FirstScreen(
                onNavigateToSecondScreen = {
                    navController.navigate(Screen.Second.route)
                }
            )
        }
        composable(Screen.Second.route) {
            SecondScreen()
        }
    }
}