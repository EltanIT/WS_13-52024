package com.example.ws_13_52024.feature_app.presentation.VerificationPass.components

import android.content.ClipboardManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun VerificationPassAlertDialog(
    value: String,
    generatedPass: String,
    onValueChangeListener: (String) -> Unit,
    onDismiss: () -> Unit,
    onGenerate: () -> Unit
) {

    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .blur(12.dp)
                .clickable { onDismiss() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                Modifier
                    .padding(horizontal = 20.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Box(Modifier.background(BlueColor, CircleShape)){
                    Image(
                        painter = painterResource(id = R.drawable.ic_email),
                        contentDescription = null,
                        Modifier.padding(10.dp)
                    )
                }

                Spacer(modifier =  Modifier.height(24.dp))
                Text(
                    text = "Генератор пароля",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xff2B2B2B),
                        fontFamily = FontFamily(MyFontFamily)
                    )
                )
                Spacer(modifier =  Modifier.height(8.dp))
                TextField(
                    value = value,
                    onValueChange = onValueChangeListener,
                    label = {
                        Text(
                            text = "Введите фразу",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 20.sp,
                                fontWeight = FontWeight(400),
                                color = GrayColor,
                                fontFamily = FontFamily(MyFontFamily),
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                    },
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Spacer(modifier =  Modifier.height(8.dp))

                Text(
                    text = generatedPass,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = GrayColor,
                        fontFamily = FontFamily(MyFontFamily),
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(horizontal = 10.dp).clickable {
                        clipboardManager.setText(AnnotatedString((generatedPass)))
                    }
                )

                CustomPrimaryButton(title = "Сгенерировать", onClick = onGenerate, modifier = Modifier.padding(horizontal = 10.dp))

                Spacer(modifier =  Modifier
                    .height(30.dp))
            }
        }
    }
}