package com.example.ws_13_52024.feature_app.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ws_13_52024.feature_app.presentation.Home.HomeScreen


@Composable
fun BottomNavHost(
    navHostController: NavHostController,
    mainNavController: NavController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    val view = LocalView.current


    androidx.navigation.compose.NavHost(
        navHostController,
        startDestination,
        modifier = modifier
    ){

        composable(Route.Home.route){
            HomeScreen(navController = mainNavController)
        }

        composable(Route.Favorite.route){
            HomeScreen(navController = mainNavController)
        }
    }
}