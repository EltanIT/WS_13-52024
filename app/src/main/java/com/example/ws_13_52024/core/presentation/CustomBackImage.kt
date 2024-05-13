package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor


@Composable
fun CustomBackImage(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    
    IconButton(
        modifier = modifier
            .background(LightGrayColor, CircleShape),
        onClick = onClick
    ) {
        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = null)
    }
}