package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor


@Composable
fun CustomFloatButton(
    icon: Int,
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit
) {

    IconButton(
        onClick = onClickListener,
        modifier = modifier
            .size(52.dp)
            .background(BlueColor, CircleShape)
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = null, tint = Color.White)
    }
}