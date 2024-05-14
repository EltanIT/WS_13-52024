package com.example.ws_13_52024.feature_app.presentation.Favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomProductItemView
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = koinViewModel()
) {

    val state = viewModel.state.value


    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xffF7F7F9))
    ) {
        Box(
            Modifier.padding(horizontal = 20.dp).fillMaxWidth()
        ) {
            CustomBackImage(
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
            ) {
                navController.popBackStack()
            }
            
            Text(
                text = "Избранное",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(MyFontFamily),
                    color = Color.Black
                ),
                modifier = Modifier.align(Alignment.Center)
            )

            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .background(Color.White, CircleShape),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorites),
                    contentDescription = null,
                    tint = Color.Black,

                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        LazyColumn {
            items(state.products){ item ->
                CustomProductItemView(
                    productData = item,
                    inCard = true,
                    isFavorite = true,
                    onCardClick = {},
                    onFavoriteClick = {}
                ) {
                    navController.navigate(Route.ProductDetails.route.replace("{id}", item.id))
                }

            }
        }
    }
}