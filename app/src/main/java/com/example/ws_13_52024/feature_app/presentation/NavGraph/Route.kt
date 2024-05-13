package com.example.ws_13_52024.feature_app.presentation.NavGraph

sealed class Route(val route: String) {


    data object SplashScreen: Route("SplashScreen")
    data object Onboard: Route("Onboard")


    data object SignIn: Route("SignIn")
    data object SignUp: Route("SignUp")
    data object ForgotPassword: Route("ForgotPassword")
    data object Verification: Route("Verification")


    data object Home: Route("Home")


    data object AuthGraph: Route("AuthGraph")
    data object AppGraph: Route("AppGraph")

}