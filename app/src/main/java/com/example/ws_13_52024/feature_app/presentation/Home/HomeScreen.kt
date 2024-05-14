package com.example.ws_13_52024.feature_app.presentation.Home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import coil.compose.AsyncImage
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomCategoryItemView
import com.example.ws_13_52024.core.presentation.CustomFloatButton
import com.example.ws_13_52024.core.presentation.CustomProductItemView
import com.example.ws_13_52024.core.presentation.CustomSearchTextField
import com.example.ws_13_52024.core.presentation.ExceptionAlertDialog
import com.example.ws_13_52024.feature_app.presentation.Home.components.HomeTopBar
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state = viewModel.state.value


    if (state.exception.isNotEmpty()){
        ExceptionAlertDialog(exception = state.exception) {
            viewModel.resetException()
        }
    }
    Column(
        Modifier
            .background(Color(0xffF7F7F9))
            .fillMaxSize()
    ) {
        HomeTopBar(onDrawerOpen = {}, cardClick = {}, cardIsEmpty = state.cardIsEmpty, modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(19.dp))

        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,

        ) {
            CustomSearchTextField(
                value = "",
                onValueChange = {},
                hilt = "Поиск",
                microIsTrue = false,
                modifier = Modifier
                    .weight(1f)
                    .clickable { navController.navigate(Route.Search.route) }
            )
            Spacer(modifier = Modifier.width(14.dp))
            CustomFloatButton(icon = R.drawable.ic_filters) {
                
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Категории",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(MyFontFamily),
                color = Color.Black
            ),
            modifier = Modifier.padding(start = 22.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(state.categories){ item ->
                CustomCategoryItemView(value = item.name) {
                    navController.navigate(Route.Listing.route.replace("{category}", item.id))
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Spacer(modifier = Modifier.height(24.dp))


        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Популярное",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(MyFontFamily),
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 11.dp)
            )
            Text(
                text = "Все",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(MyFontFamily),
                    color = BlueColor
                ),
                modifier = Modifier
                    .padding(end = 28.dp)
                    .clickable { }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier
                .padding(horizontal = 21.dp)
                .fillMaxWidth()
        ) {
            repeat(state.populars.size){
                CustomProductItemView(
                    productData = state.populars[it],
                    inCard = true,
                    isFavorite = true,
                    modifier = Modifier.weight(1f),
                    onCardClick = {  },
                    onFavoriteClick = {  }) {
                    navController.navigate(
                        Route.ProductDetails.route.replace("{id}", state.populars[it].id)
                    )
                }
                if (it==0){
                    Spacer(modifier = Modifier.width(19.dp))
                }

            }
        }

        
        Spacer(modifier = Modifier.height(40.5.dp))

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Акции",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(MyFontFamily),
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 18.dp)
            )
            Text(
                text = "Все",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 15.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(MyFontFamily),
                    color = BlueColor
                ),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .clickable { }
            )
        }
        Spacer(modifier = Modifier.height(21.dp))
        
        AsyncImage(model = state.actia, contentDescription = null)
    }
}