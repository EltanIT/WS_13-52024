@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.example.ws_13_52024.feature_app.presentation.Onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.Onboard.components.CustomPagerIndicator
import com.example.ws_13_52024.feature_app.presentation.Onboard.components.OnboardFirstPage
import com.example.ws_13_52024.feature_app.presentation.Onboard.components.OnboardPage
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BackgroundColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun OnboardScreen(
    navController: NavController,
    viewModel: OnboardViewModel = koinViewModel()
) {

    var getFirstItem by remember {
        mutableStateOf(false)
    }

    var currentPage by remember {
        mutableIntStateOf(0)
    }

    val state = viewModel.state.value

    LaunchedEffect(key1 = !getFirstItem) {
        if (!getFirstItem){
            viewModel.onEvent(OnboardEvent.NextPage)
            getFirstItem = true
        }
    }

    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.SignIn.route){
                popUpTo(Route.Onboard.route){
                    inclusive = true
                }
            }
        }
    }
    Column(
        Modifier
            .background(BackgroundColor)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val pagerState = rememberPagerState {
            state.size
        }
        Box{
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false
            ) { page ->
                if (state.page.title.isEmpty()){
                    OnboardFirstPage()
                }else{
                    OnboardPage(page = state.page, index = if (state.size == 3) currentPage else currentPage+1)
                }
            }
            if (state.page.title.isEmpty()){
                CustomPagerIndicator(
                    selectedPage = 0,
                    count = state.size,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-145).dp)
                )
            }
        }
        if (state.page.title.isNotEmpty()){
            Spacer(modifier = Modifier.height(40.dp))
            CustomPagerIndicator(
                selectedPage = currentPage,
                count = state.size
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        CustomPrimaryButton(
            title = if (state.page.title.isEmpty()) "Начать" else "Далее",
            onClick = {
                viewModel.onEvent(OnboardEvent.NextPage)
                currentPage++
            },
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(36.dp))
    }
}