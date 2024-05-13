package com.example.ws_13_52024.feature_app.presentation.Onboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.R


@Composable
fun OnboardFirstPage(

) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(65.dp))
        
        Box(Modifier.fillMaxWidth()){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Text(text = "ДОБРО \nПОЖАЛОВАТЬ", style = TextStyle(
                        fontSize = 30.sp,
                        lineHeight = 35.22.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(900),
                        color = Color(0xffECECEC)
                    ))
                    Image(
                        painter = painterResource(id = R.drawable.ic_highlight_05_1),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .offset(y = (-15).dp, x = 5.dp)
                    )
                }
                Box{
                    Image(
                        painter = painterResource(id = R.drawable.ic_onboard1_vector),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 19.dp).align(Alignment.TopCenter)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_onboard1_group),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 29.dp)
                            .fillMaxWidth()
                    )
                }
            }
            
            Image(
                painter = painterResource(id = R.drawable.ic_onboard1),
                contentDescription = null,
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

    }
}