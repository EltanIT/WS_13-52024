package com.example.ws_13_52024.feature_app.presentation.Home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import com.example.ws_13_52024.feature_app.presentation.ui.theme.RedColor


@Composable
fun HomeTopBar(
    onDrawerOpen: () -> Unit,
    cardClick: () -> Unit,
    cardIsEmpty: Boolean,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onDrawerOpen) {
            Image(painter = painterResource(id = R.drawable.ic_open_drawer), contentDescription = null)
        }
        
        Box {
            Text(text = "Главная", style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 37.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(MyFontFamily),
                color = Color.Black
            ))
            
            Image(
                painter = painterResource(id = R.drawable.ic_home_main),
                contentDescription = null,
                modifier = Modifier.offset(y = (-8).dp, x = (-16).dp)
            )
        }

        Box(
            Modifier
                .size(44.dp)
                .background(Color.White, CircleShape)
                .clip(CircleShape)
                .clickable { cardClick() }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_card),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
            
            if (!cardIsEmpty){
                Box(modifier = Modifier
                    .padding(top = 3.dp, end = 2.dp)
                    .size(8.dp)
                    .background(RedColor, CircleShape)
                    .align(Alignment.TopEnd)
                )
            }
        }

       

    }
}