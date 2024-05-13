package com.example.ws_13_52024.feature_app.presentation.NavGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardScreen
import com.example.ws_13_52024.feature_app.presentation.SplashScreen.SplashScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    startDestination: String
) {

    navigation(Route.SplashScreen.route, Route.AuthGraph.route){
        composable(Route.SplashScreen.route){
            SplashScreen{
                navController.navigate(startDestination){
                    popUpTo(Route.SplashScreen.route){
                        inclusive = true
                    }
                }
            }
        }

        composable(Route.Onboard.route){
            OnboardScreen(navController = navController)
        }

        composable(Route.SignIn.route){

        }
    }

}