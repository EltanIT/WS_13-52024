package com.example.ws_13_52024.feature_app.presentation.VerificationPass.components

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_13_52024.feature_app.presentation.ui.theme.RedColor


@Composable
fun VerificationCodeField(
    value: String,
    size: Int,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onValueChangeListener: (String) -> Unit
) {

    BasicTextField(
        value = value,
        enabled = enabled,
        modifier = modifier,
        onValueChange = onValueChangeListener,
        decorationBox = {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(size){ index ->
                    CodeItem(
                        char = when {
                            index == value.length -> ""
                            index > value.length -> ""
                            else -> value[index].toString()
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun CodeItem(
    char: String
) {
    Box(
        modifier = Modifier
            .background(Color(0xffF7F7F9), RoundedCornerShape(12.dp))
            .border(1.dp, if (char.isEmpty()) RedColor else Color.Transparent, RoundedCornerShape(12.dp))
            .width(46.dp)
            .height(99.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = char, style = TextStyle(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(600),
            color = Color(0xff2B2B2B)
        ))
    }
}