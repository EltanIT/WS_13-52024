package com.example.ws_13_52024.feature_app.presentation.NavGraph

import android.view.View
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ws_13_52024.feature_app.presentation.Listing.ListingScreen
import com.example.ws_13_52024.feature_app.presentation.Listing.ListingViewModel
import com.example.ws_13_52024.feature_app.presentation.MainScreen.MainScreen
import com.example.ws_13_52024.feature_app.presentation.ProductDetails.ProductDetailsScreen
import com.example.ws_13_52024.feature_app.presentation.ProductDetails.ProductDetailsViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.appNavGraph(
    navController: NavController,
    startDestination: String,
    view: View
) {

    navigation(Route.MainScreen.route, Route.AppGraph.route){
        composable(Route.MainScreen.route){
           MainScreen(navController)
        }

        composable(Route.ProductDetails.route){

            val viewModel: ProductDetailsViewModel = koinViewModel()

            LaunchedEffect(key1 = true) {
                viewModel.setId(it.arguments?.getString("id")?:"")
            }

            ProductDetailsScreen(navController, viewModel)
        }

        composable(Route.Listing.route){

            val viewModel: ListingViewModel = koinViewModel()

            LaunchedEffect(key1 = true) {
                viewModel.setId(it.arguments?.getString("id")?:"")
            }

            ListingScreen(navController, viewModel)
        }
    }


}