package com.example.ws_13_52024.feature_app.presentation.NavGraph

import android.app.Activity
import android.view.View
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ws_13_52024.feature_app.presentation.ForgotPass.ForgotPassScreen
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardScreen
import com.example.ws_13_52024.feature_app.presentation.SignIn.SignInScreen
import com.example.ws_13_52024.feature_app.presentation.SignUp.SignUpScreen
import com.example.ws_13_52024.feature_app.presentation.SplashScreen.SplashScreen
import com.example.ws_13_52024.feature_app.presentation.VerificationPass.VerificationPassScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController,
    startDestination: String,
    view: View
) {


    navigation(Route.SplashScreen.route, Route.AuthGraph.route){
        composable(Route.SplashScreen.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color(0xff48B2E7).toArgb()
                }
            }

            SplashScreen{
                navController.navigate(startDestination){
                    popUpTo(Route.SplashScreen.route){
                        inclusive = true
                    }
                }
            }
        }

        composable(Route.Onboard.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color(0xff48B2E7).toArgb()
                }
            }
            OnboardScreen(navController = navController)
        }

        composable(Route.SignIn.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.White.toArgb()
                }
            }
            SignInScreen(navController = navController)
        }

        composable(Route.SignUp.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.White.toArgb()
                }
            }
            SignUpScreen(navController = navController)
        }

        composable(Route.ForgotPassword.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.White.toArgb()
                }
            }

            ForgotPassScreen(navController = navController)

        }

        composable(Route.Verification.route){
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = Color.White.toArgb()
                }
            }

            VerificationPassScreen(navController = navController)

        }
    }

}