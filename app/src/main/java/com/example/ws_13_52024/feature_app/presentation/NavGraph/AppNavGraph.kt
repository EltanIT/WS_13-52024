package com.example.ws_13_52024.feature_app.presentation.NavGraph

import android.view.View
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.ws_13_52024.feature_app.presentation.Card.CardScreen
import com.example.ws_13_52024.feature_app.presentation.CheckOut.CheckOutScreen
import com.example.ws_13_52024.feature_app.presentation.CheckOut.CheckOutViewModel
import com.example.ws_13_52024.feature_app.presentation.Favorite.FavoriteScreen
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
                viewModel.setId(it.arguments?.getString("category")?:"")
            }

            ListingScreen(navController, viewModel)
        }

        composable(Route.Card.route){
            CardScreen(navController)
        }

        composable(Route.Favorite.route){
            FavoriteScreen(navController)
        }

        composable(Route.CheckOut.route){
            val viewModel: CheckOutViewModel = koinViewModel()

            LaunchedEffect(key1 = true) {
                viewModel.setSum(it.arguments?.getString("sum")?:"")
            }

            CheckOutScreen(navController, viewModel)
        }
    }


}