package com.example.cats.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.cats.ui.screen.DetailScreen
import com.example.cats.ui.screen.HomeScreen
import com.example.cats.ui.screen.SplashScreen

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash,
        enterTransition = { slideInVertically() + fadeIn() },
        popEnterTransition = { slideInVertically() + fadeIn() },
        exitTransition = { slideOutVertically() + fadeOut() },
        popExitTransition = { slideOutVertically() + fadeOut() },
    ) {
        composable<Screen.Splash> {
            SplashScreen(
                onNavigationClick = {
                    navController.navigate(Screen.Home)
                }
            )
        }
        composable<Screen.Home> {
            HomeScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onCatClick = { catName, description ->
                    navController.navigate(Screen.Detail(catName, description))
                }
            )
        }
        composable<Screen.Detail> {
            val (catName, description) = it.toRoute<Screen.Detail>()

            DetailScreen(
                catName = catName,
                description = description,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}