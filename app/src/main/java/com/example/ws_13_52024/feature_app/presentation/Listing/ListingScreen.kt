package com.example.ws_13_52024.feature_app.presentation.Listing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.ws_13_52024.core.presentation.CustomCategoryItemView
import com.example.ws_13_52024.core.presentation.CustomProductItemView
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import com.example.ws_13_52024.feature_app.presentation.ui.theme.RedColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListingScreen(
    navController: NavController,
    viewModel: ListingViewModel = koinViewModel()
) {


    val state = viewModel.state.value


    Column {
        CustomBackImage(
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        ) {
            navController.popBackStack()
        }
        Spacer(modifier = Modifier.height(16.dp))

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

                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(state.products){ item ->
                CustomProductItemView(
                    productData = item,
                    inCard = true,
                    isFavorite = true,
                    onCardClick = {},
                    onFavoriteClick = {}) {
                    navController.navigate(
                        Route.ProductDetails.route.replace("{id}", item.id)
                    )
                }
            }
        }
    }
}