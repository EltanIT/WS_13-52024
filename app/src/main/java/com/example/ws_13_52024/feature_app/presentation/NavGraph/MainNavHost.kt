package com.example.ws_13_52024.feature_app.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String,
    startGraphDestination: String,
) {

    androidx.navigation.compose.NavHost(navHostController, startGraphDestination){
        authNavGraph(navHostController, startDestination)
    }
}