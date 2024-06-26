package com.example.ws_13_52024.feature_app.presentation.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BackgroundColor
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    onComplete: () -> Unit
) {

    LaunchedEffect(key1 = true) {
        delay(2000)
        onComplete()
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.padding(horizontal = 22.dp)
        )
    }
}