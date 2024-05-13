package com.example.ws_13_52024.feature_app.presentation.NavGraph

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavHostController


@Composable
fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String,
    startGraphDestination: String,
) {
    val view = LocalView.current


    androidx.navigation.compose.NavHost(navHostController, startGraphDestination){

        authNavGraph(navHostController, startDestination, view)

        appNavGraph(navHostController, startDestination, view)
    }
}