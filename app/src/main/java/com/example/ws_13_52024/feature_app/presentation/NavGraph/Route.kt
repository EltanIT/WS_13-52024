package com.example.ws_13_52024.feature_app.presentation.NavGraph

sealed class Route(val route: String) {


    data object SplashScreen: Route("SplashScreen")
    data object Onboard: Route("Onboard")


    data object SignIn: Route("SignIn")


    data object AuthGraph: Route("AuthGraph")

}