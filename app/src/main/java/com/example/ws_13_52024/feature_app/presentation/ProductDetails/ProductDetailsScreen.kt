package com.example.ws_13_52024.feature_app.presentation.ProductDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.core.presentation.ExceptionAlertDialog
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import com.example.ws_13_52024.feature_app.presentation.ui.theme.RedColor
import org.koin.androidx.compose.koinViewModel
import kotlin.math.abs
import kotlin.math.roundToInt


@Composable
fun ProductDetailsScreen(
    navController: NavController,
    viewModel: ProductDetailsViewModel = koinViewModel()
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
            .verticalScroll(rememberScrollState())
            .background(LightGrayColor)
    ) {
        Row(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomBackImage(
                color = Color.White
            ) {
                navController.popBackStack()
            }
            Text(text = state.product?.shop ?: "", style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(600),
                fontFamily = FontFamily(MyFontFamily),
                color = Color.Black
            ))

            Box(
                Modifier
                    .size(44.dp)
                    .background(Color.White, CircleShape)
                    .clip(CircleShape)
                    .clickable { navController.navigate(Route.Card.route) }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_card),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )

                if (!state.cardIsEmpty){
                    Box(modifier = Modifier
                        .padding(top = 3.dp, end = 2.dp)
                        .size(8.dp)
                        .background(RedColor, CircleShape)
                        .align(Alignment.TopEnd)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(26.dp))
        Text(text = state.product?.name ?: "", style = TextStyle(
            fontSize = 26.sp,
            lineHeight = 30.sp,
            fontWeight = FontWeight(700),
            fontFamily = FontFamily(MyFontFamily),
            color = Color.Black
        ),
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(0.7f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Men’s Shoes", style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 18.sp,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(MyFontFamily),
            color = DarkGrayColor
        ),
            modifier = Modifier
                .padding(start = 20.dp)
        )


        Spacer(modifier = Modifier.height(8.dp))

        Text(text =  "₽${state.product?.price}", style = TextStyle(
            fontSize = 24.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight(600),
            fontFamily = FontFamily(MyFontFamily),
            color = Color.Black
        ),
            modifier = Modifier
                .padding(start = 20.dp)
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            Modifier
                .height(167.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = state.product?.image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
        }


        var position by remember {
            mutableFloatStateOf(0f)
        }

        var kof by remember {
            mutableFloatStateOf(0f)
        }

        var sizeSlider by remember {
            mutableStateOf(IntSize(0, 0))
        }

        var sliderIsPressing by remember {
            mutableStateOf(false)
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                sizeSlider = it.size
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        sliderIsPressing = false
                    },
                    onDragCancel = {
                        sliderIsPressing = false
                    }
                ) { _, dragAmount ->
                    position += dragAmount

                    if (position in -215f..215f && sliderIsPressing) {
                        kof =
                            (size.height / 14).toFloat() / (sizeSlider.width / 2 + (abs(position) * -1))
                    } else {
                        position -= dragAmount
                    }

                }
            }
        ){
            Image(painter = painterResource(id = R.drawable.ic_slider), contentDescription = null, Modifier.padding(bottom = 6.dp))

            var height by remember {
                mutableIntStateOf(0)
            }

            Image(
                painter = painterResource(id = R.drawable.ic_slider_),
                contentDescription = null,
                modifier = Modifier
                    .onGloballyPositioned {
                        height = it.size.height
                    }
                    .offset {
                        IntOffset(
                            position.roundToInt(),
                            if (position < 0) {
                                (position * kof).roundToInt()
                            } else {
                                (position * -kof).roundToInt()
                            }

                        )
                    }
                    .rotate(-(position * kof))
                    .align(Alignment.BottomCenter)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                sliderIsPressing = true
                            },
                            onTap = {
                                sliderIsPressing = false
                            }
                        )
                    }
            )
        }

       Spacer(modifier = Modifier.height(28.dp))


        LazyRow(
            Modifier
                .padding(start = 14.dp)
                .fillMaxWidth()
        ) {
            items(5){
                Box(
                    modifier = Modifier
                        .background(Color.White, CircleShape)
                        .size(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_product),
                        contentDescription = null,
                        modifier = Modifier.rotate(30f),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
            }
        }
        
        Spacer(modifier = Modifier.height(33.dp))

        Text(text = state.product?.description ?: "", style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(MyFontFamily),
            color = DarkGrayColor
        ),
            modifier = Modifier
                .padding(horizontal = 20.dp),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(9.dp))

        Text(text = "Подробнее", style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 21.sp,
            fontWeight = FontWeight(400),
            fontFamily = FontFamily(MyFontFamily),
            color = Color(0xff0D6EFD),
            textAlign = TextAlign.End
        ),
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth()
                .clickable { }
        )


        Spacer(modifier = Modifier.weight(1f))

        Row(
            Modifier
                .padding(start = 48.dp, end = 27.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .background(Color(0xffD9D9D9), CircleShape),
                onClick = {viewModel.onEvent(ProductDetailsEvent.AddInFavorite(state.product?.id?:""))}
            ) {
                Image(painter = painterResource(id = R.drawable.ic_favorites), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(40.dp))

            Row(
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .background(BlueColor, RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {  },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_card),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "В корзину",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.44.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        fontFamily = FontFamily(MyFontFamily)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(41.dp))

    }
}