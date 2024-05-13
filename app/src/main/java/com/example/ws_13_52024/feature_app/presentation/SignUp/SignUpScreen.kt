package com.example.ws_13_52024.feature_app.presentation.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_13_52024.core.presentation.CustomAuthCheckBox
import com.example.ws_13_52024.core.presentation.CustomAuthTextField
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.core.presentation.ExceptionAlertDialog
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.SignIn.SignInEvent
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BackgroundColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = koinViewModel()
) {

    val state = viewModel.state.value


    if (state.exception.isNotEmpty()){
        ExceptionAlertDialog(exception = state.exception) {
            viewModel.resetException()
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
            text = "Регистрация",
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
            text = "Заполните Свои данные или продолжите через социальные медиа",
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

        Text(text = "Ваше имя", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.Black,
            fontFamily = FontFamily(MyFontFamily)
        ),
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomAuthTextField(
            value = state.name,
            onValueChange = {viewModel.onEvent(SignUpEvent.EnteredName(it))},
            hilt = "xxxxxxxx",
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )


        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Email", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(500),
            color = Color.Black,
            fontFamily = FontFamily(MyFontFamily)
        ),
            modifier = Modifier
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomAuthTextField(
            value = state.email,
            onValueChange = {viewModel.onEvent(SignUpEvent.EnteredEmail(it))},
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
        ),
            modifier = Modifier
                .padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomAuthTextField(
            value = state.password,
            onValueChange = {viewModel.onEvent(SignUpEvent.EnteredPassword(it))},
            hilt = "********",
            isPassword = true,
            Modifier.padding(horizontal = 20.dp)
        )



        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomAuthCheckBox(isCheck = state.policeIsCheck) {
                viewModel.onEvent(SignUpEvent.CheckPolice)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Даю согласие на обработку персональных данных", style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(500),
                color = Color(0xff6A6A6A),
                textAlign = TextAlign.Start,
                textDecoration = TextDecoration.Underline,
                fontFamily = FontFamily(MyFontFamily)
            )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        CustomPrimaryButton(
            title = "Войти",
            onClick = { viewModel.onEvent(SignUpEvent.SignUp) },
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
                text = "Есть аккаунт? ",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = DarkGrayColor,
                    fontFamily = FontFamily(MyFontFamily)
                ),
            )

            Text(
                text = "Войти",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xff2B2B2B),
                    fontFamily = FontFamily(MyFontFamily)
                ),
                modifier = Modifier.clickable {
                    navController.navigate(Route.SignIn.route){
                        launchSingleTop
                    }
                }
            )
        }
    }
}