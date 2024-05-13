package com.example.ws_13_52024.feature_app.presentation.ForgotPass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import com.example.ws_13_52024.core.presentation.CustomAuthTextField
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.feature_app.presentation.ForgotPass.components.ForgotPassAlertDialog
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun ForgotPassScreen(
    navController: NavController,
    viewModel: ForgotPassViewModel = koinViewModel()
) {

    val state  = viewModel.state.value

    if (state.isComplete){
        ForgotPassAlertDialog {
            navController.navigate(Route.Verification.route){
                viewModel.resetComplete()
            }
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
            text = "Забыл пароль",
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
            text = "Введите свою учетную запись\n" +
                    " для сброса",
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

        CustomAuthTextField(
            value = state.email,
            onValueChange = {viewModel.onEvent(ForgotPassEvent.EnteredEmail(it))},
            hilt = "xyz@gmail.com",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )


        Spacer(modifier = Modifier.height(40.dp))

        CustomPrimaryButton(
            title = "Отправить",
            onClick = { viewModel.onEvent(ForgotPassEvent.Send) },
            isLoading = state.isLoading,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
    }
}