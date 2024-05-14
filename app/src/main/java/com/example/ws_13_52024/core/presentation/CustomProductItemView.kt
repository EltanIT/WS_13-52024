package com.example.ws_13_52024.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily


@Composable
fun CustomProductItemView(
        productData: ProductData,
        inCard: Boolean,
        isFavorite: Boolean,
        modifier: Modifier = Modifier,
        onCardClick: () -> Unit,
        onFavoriteClick: () -> Unit,
        onClick: () -> Unit,
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(
            1.dp
        ),
        modifier = modifier
    ) {

        Box{
            Column(
                Modifier.padding(horizontal = 9.dp)
            ) {
                Spacer(modifier = Modifier.height(3.dp))
                if (isFavorite){
                    IconButton(onClick = onFavoriteClick, modifier = Modifier
                        .size(29.dp)
                        .background(Color(0xffF7F7F9), CircleShape)
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_heart), contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.height(3.dp))
                AsyncImage(
                    model = productData.image,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .height(53.dp),
                    contentScale = ContentScale.FillHeight
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "BEST SELLER", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(
                            MyFontFamily
                        ),
                        color = BlueColor
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = productData.name, style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(600),
                        fontFamily = FontFamily(
                            MyFontFamily
                        ),
                        color = DarkGrayColor
                    )
                )

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "₽${productData.price}", style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(
                            MyFontFamily
                        ),
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable { onCardClick() },
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.ic_card_background), contentDescription = null)

                if (inCard){
                    Image(painter = painterResource(id = R.drawable.ic_card_car), contentDescription = null)
                }else{
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

        }

    }
}