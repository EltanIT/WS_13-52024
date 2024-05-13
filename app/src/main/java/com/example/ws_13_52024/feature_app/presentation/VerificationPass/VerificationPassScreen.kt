package com.example.ws_13_52024.feature_app.presentation.VerificationPass

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.feature_app.presentation.VerificationPass.components.VerificationCodeField
import com.example.ws_13_52024.feature_app.presentation.VerificationPass.components.VerificationPassAlertDialog
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun VerificationPassScreen(
    navController: NavController,
    viewModel: VerificationPassViewModel = koinViewModel()
) {

    val state  = viewModel.state.value

    if (state.isComplete){
        VerificationPassAlertDialog(
            value = state.phrase,
            generatedPass = state.password,
            onValueChangeListener = {viewModel.onEvent(VerificationPassEvent.EnteredPhrase(it))},
            onDismiss = {
                viewModel.resetComplete()
            }) {

        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(23.dp))
        CustomBackImage(
            Modifier.padding(start = 20.dp)
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(11.dp))
        Text(
            text = "OTP проверка",
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 37.5.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                color = Color.Black,
                fontFamily = FontFamily(MyFontFamily)
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Пожалуйста, проверьте свою электронную почту, чтобы увидеть код подтверждения",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(400),
                color = Color(0xff707B81),
                fontFamily = FontFamily(MyFontFamily)
            ),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "OTP Код", style = TextStyle(
            fontSize = 21.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(600),
            color = Color.Black,
            fontFamily = FontFamily(MyFontFamily)
        ),     modifier = Modifier
            .padding(start = 34.dp))


        Spacer(modifier = Modifier.height(16.dp))

        VerificationCodeField(
            value = state.code,
            size = 6,
            enabled = !state.isLoading,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            viewModel.onEvent(VerificationPassEvent.EnteredCode(it))
        }
        
        Spacer(modifier = Modifier.height(22.dp))

        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Отправить заново", style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xff7D848D),
                fontFamily = FontFamily(MyFontFamily)
            ),
                modifier = Modifier.clickable {
                    if (state.timer.equals("00:00")){
                        viewModel.onEvent(VerificationPassEvent.RestartTimer)
                    }
                })
            Spacer(modifier = Modifier.weight(1f))
            Text(text = state.timer, style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 14.sp,
                fontWeight = FontWeight(400),
                color = Color(0xff7D848D),
                fontFamily = FontFamily(MyFontFamily)
            ))

        }
    }
}