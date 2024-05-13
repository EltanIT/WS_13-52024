package com.example.ws_13_52024.feature_app.presentation.Onboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun OnboardPage(
    page: OnboardItem?,
    index: Int
) {

    Column(
        modifier = Modifier.padding(horizontal = 26.dp)
    ) {
        Box(
            Modifier
                .padding(top = 65.dp)
                .fillMaxWidth()) {
            Image(
                painter = painterResource(id = if (index == 1) R.drawable.ic_highlight_10 else R.drawable.ic_misc_04_2),
                contentDescription = null
            )

            if (index == 1){
                Image(
                    painter = painterResource(id = R.drawable.ic_misc_04_1),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                )
            }

            Image(
                painter = painterResource(id = page?.image ?: 0),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(top = 14.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.TopCenter)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = page?.title ?: "", style = TextStyle(
            fontSize = 34.sp,
            lineHeight = 44.2.sp,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(MyFontFamily),
            color = Color(0xffECECEC)
        ))
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = page?.description ?: "", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(400),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(MyFontFamily),
            color = Color(0xffD8D8D8)
        ))
    }
}