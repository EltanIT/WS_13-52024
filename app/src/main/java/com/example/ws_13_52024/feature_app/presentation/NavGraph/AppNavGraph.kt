package com.example.ws_13_52024.feature_app.presentation.NavGraph

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ws_13_52024.feature_app.presentation.Home.HomeScreen

fun NavGraphBuilder.appNavGraph(
    navController: NavController,
    startDestination: String,
    view: View
) {

    navigation(Route.Home.route, Route.AppGraph.route){
        composable(Route.Home.route){
           HomeScreen()
        }
    }


}