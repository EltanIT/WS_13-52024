package com.example.ws_13_52024.feature_app.presentation.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomCardItem
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun CardScreen(
    navController: NavController,
    viewModel: CardViewModel = koinViewModel()
) {

    val state = viewModel.state.value

    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xffF7F7F9))
    ) {

        Box(
            Modifier.fillMaxWidth()
        ) {
            CustomBackImage(
                color = Color.White,
                modifier = Modifier.padding(start = 20.dp).align(Alignment.CenterStart)
            ) {
                navController.popBackStack()
            }
            Text(
                text = "Коризина",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(MyFontFamily),
                    color = Color.Black
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${state.card.size} товара",
            style =
            TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily(MyFontFamily)
            ),
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(state.card){ item ->
                CustomCardItem(
                    item = item,
                    onPlus = { viewModel.onEvent(CardEvent.Plus(item.id)) },
                    onMinus = { viewModel.onEvent(CardEvent.Minus(item.id)) },
                    onDelete = { viewModel.onEvent(CardEvent.Delete(item.id)) },
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                
                Spacer(modifier = Modifier.height(14.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))


        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(34.dp))
            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Сумма",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = GrayColor
                    )
                )

                Text(
                    text = "₽${state.sum}",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Доставка",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = GrayColor
                    )
                )

                Text(
                    text = "₽60.20",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Divider()

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Итого",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )

                Text(
                    text = "₽${state.sum+60.14}",
                    style =
                    TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            CustomPrimaryButton(
                title = "Оформить Заказ",
                onClick = { navController.navigate(Route.CheckOut.route.replace("{sum}", state.sum.toString()))},
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
        }

    }
}