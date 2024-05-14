package com.example.ws_13_52024.feature_app.presentation.SignIn

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.ws_13_52024.core.presentation.CustomAuthTextField
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.core.presentation.ExceptionAlertDialog
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    if (state.exception.isNotEmpty()){
        ExceptionAlertDialog(exception = state.exception) {
            viewModel.resetException()
        }
    }


    LaunchedEffect(key1 = !state.isComplete) {
        if (state.isComplete){
            navController.navigate(Route.MainScreen.route)
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
            text = "Привет", 
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 37.5.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                color = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Заполните Свои данные или продолжите через социальные медиа",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(400),
                color = Color(0xff707B81)
            ),
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Email", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.Black
        ),
            modifier = Modifier
                .padding(start = 20.dp))
        Spacer(modifier = Modifier.height(12.dp))
        CustomAuthTextField(
            value = state.email,
            onValueChange = {viewModel.onEvent(SignInEvent.EnteredEmail(it))},
            hilt = "xyz@gmail.com",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )


        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Пароль", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.Black,
            fontFamily = FontFamily(MyFontFamily)
        ),     modifier = Modifier
            .padding(start = 20.dp))
        Spacer(modifier = Modifier.height(12.dp))
        CustomAuthTextField(
            value = state.password,
            onValueChange = {viewModel.onEvent(SignInEvent.EnteredPassword(it))},
            hilt = "********",
            isPassword = true,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "Восстановить",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = GrayColor,
                    fontFamily = FontFamily(MyFontFamily)
                ),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .clickable {
                        navController.navigate(Route.ForgotPassword.route) {
                            launchSingleTop
                        }
                    }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        CustomPrimaryButton(
            title = "Войти",
            onClick = { viewModel.onEvent(SignInEvent.SignIn) },
            isLoading = state.isLoading,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            Modifier
                .padding(bottom = 47.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Вы впервые? ",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = DarkGrayColor,
                    fontFamily = FontFamily(MyFontFamily)
                ),
            )

            Text(
                text = "Создать пользователя",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xff2B2B2B),
                    fontFamily = FontFamily(MyFontFamily)
                ),
                modifier = Modifier.clickable {
                    navController.navigate(Route.SignUp.route){
                        launchSingleTop
                    }
                }
            )
        }
    }
}