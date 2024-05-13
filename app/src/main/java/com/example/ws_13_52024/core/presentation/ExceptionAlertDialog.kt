package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun ExceptionAlertDialog(
    exception: String,
    onDismiss: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            CustomPrimaryButton(title = "Ok", onClick = onDismiss)
        },
        title = {
            Text(
                text = "Ошибка",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xff2B2B2B),
                    fontFamily = FontFamily(MyFontFamily)
                )
            )
        },
        text = {
            Text(
                text = exception,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = GrayColor,
                    fontFamily = FontFamily(MyFontFamily),
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    )
}