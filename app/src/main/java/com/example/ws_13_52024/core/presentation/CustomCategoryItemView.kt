package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun CustomCategoryItemView(
    value: String,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(width = 108.dp, height = 40.dp)
            .background(Color.White, CircleShape)
            .clip(CircleShape)
            .clickable { onClick() }
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(MyFontFamily)
        ))
    }
}