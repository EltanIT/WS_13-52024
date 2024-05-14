package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun CustomSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hilt: String,
    microIsTrue: Boolean,
    modifier: Modifier = Modifier
) {

    var passIsVisible by remember{
        mutableStateOf(false)
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight(500),
            color = Color.Black,
            fontFamily = FontFamily(MyFontFamily)
        ),
        modifier = modifier
            .background(Color.White, RoundedCornerShape(14.dp))
            .fillMaxWidth()
            .height(52.dp),
        decorationBox = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
                Box {
                    if (value.isEmpty()){
                        Text(
                            text = hilt,
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight(500),
                                color = DarkGrayColor,
                                fontFamily = FontFamily(MyFontFamily)
                            )
                        )
                    }
                    it()
                }
                Spacer(modifier = Modifier.weight(1f))
                if (microIsTrue){
                    Image(
                        painter = painterResource(id = R.drawable.ic_eye_slash),
                        contentDescription = null,
                        modifier = Modifier.clickable { passIsVisible = !passIsVisible }
                    )
                }

            }
        }
    )
}