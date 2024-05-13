package com.example.ws_13_52024.feature_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.ws_13_52024.feature_app.presentation.NavGraph.MainNavHost
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.WS_1352024Theme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WS_1352024Theme(
                darkTheme = false,
                dynamicColor = false
            ) {
                val viewModel: MainActivityViewModel = koinViewModel()
                LaunchedEffect(key1 = true) {
                    viewModel.checkStartDestination()
                }

                val startDestination = viewModel.startDestination.collectAsState()

                val navController = rememberNavController()
                MainNavHost(
                    navController,
                    startDestination = startDestination.value?:Route.Onboard.route,
                    startGraphDestination = Route.AuthGraph.route
                )
            }
        }
    }
}