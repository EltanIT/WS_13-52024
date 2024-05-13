package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor


@Composable
fun CustomAuthCheckBox(
    isCheck: Boolean,
    onChecked: () -> Unit
) {
    
    Box(
        modifier = Modifier
            .background(LightGrayColor, RoundedCornerShape(6.dp))
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onChecked()
            }
            .size(18.dp),
        contentAlignment = Alignment.Center
    ){
        if (isCheck){
            Image(painter = painterResource(id = R.drawable.ic_police_checkbox), contentDescription = null)
        }
    }
}