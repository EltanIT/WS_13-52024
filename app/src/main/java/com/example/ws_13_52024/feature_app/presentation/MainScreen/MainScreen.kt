package com.example.ws_13_52024.feature_app.presentation.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomFloatButton
import com.example.ws_13_52024.feature_app.presentation.NavGraph.BottomNavHost
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(
    mainNavController: NavController,
    startDestination: String = Route.Home.route,
    viewModel: MainScreenViewModel = koinViewModel()
) {

    val selectedItem = viewModel.selectedItem.collectAsState()


    val navController = rememberNavController()


    var width by remember{
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            Box(
                Modifier
                    .background(LightGrayColor)
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        width = it.size.width
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bottombar_background), 
                    contentDescription = null,
                    Modifier.fillMaxWidth()
                )
                
                CustomFloatButton(
                    icon = R.drawable.ic_card,
                    modifier = Modifier.align(Alignment.TopCenter)
                ) {
                    mainNavController.navigate(Route.Card.route)
                }

                Row(
                    modifier = Modifier
                        .offset(y = 11.dp)
                        .fillMaxWidth(0.5f)
                        .align(Alignment.CenterStart),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    repeat(2){
                        IconButton(onClick = {
                            viewModel.onEvent(MainScreenEvent.SelectItem(it))
                            navController.navigate(viewModel.navigationList[it].route)
                        }) {
                            Icon(
                                painter = painterResource(id = viewModel.navigationList[it].icon),
                                contentDescription = null,
                                tint = if (it == selectedItem.value) BlueColor else GrayColor
                            )
                        }
                        Spacer(modifier = Modifier.width(41.dp))
                    }
                }

                Row(
                    modifier = Modifier
                        .offset(y = 11.dp)
                        .fillMaxWidth(0.5f)
                        .align(Alignment.CenterEnd),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    repeat(2){
                        Spacer(modifier = Modifier.width(40.dp))
                        IconButton(onClick = {
                            viewModel.onEvent(MainScreenEvent.SelectItem(it+2))
                            mainNavController.navigate(viewModel.navigationList[it].route)
                        }
                        ) {
                            Icon(
                                painter = painterResource(id = viewModel.navigationList[it+2].icon),
                                contentDescription = null,
                                tint = if (it+2 == selectedItem.value) BlueColor else GrayColor
                            )
                        }
                    }
                }

                
            }
        }
    ) {
        BottomNavHost(
            navHostController = navController,
            mainNavController = mainNavController,
            startDestination = startDestination,
            modifier = Modifier.padding(it))
    }
}