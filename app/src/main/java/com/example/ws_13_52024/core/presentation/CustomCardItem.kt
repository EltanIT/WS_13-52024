package com.example.ws_13_52024.core.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.presentation.ui.theme.BlueColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import com.example.ws_13_52024.feature_app.presentation.ui.theme.RedColor


@Composable
fun CustomCardItem(
    item: ProductCardData,
    onPlus: () -> Unit,
    onMinus: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {

    var offsetValue by remember {
        mutableFloatStateOf(0f)
    }

    val density = LocalDensity.current

    var maxSize by remember {
        mutableStateOf(0.dp)
    }

    var itemSize by remember {
        mutableStateOf(0.dp)
    }

    var minSize by remember {
        mutableStateOf(0.dp)
    }

    var height by remember {
        mutableStateOf(0.dp)
    }

    Box(
        modifier
            .fillMaxWidth()
            .height(104.dp)
            .clip(RoundedCornerShape(8.dp))
            .onGloballyPositioned { coordinates ->
                maxSize = with(density) { coordinates.size.width.toDp() }
                height = with(density) { coordinates.size.height.toDp() }

                if (itemSize == 0.dp) {
                    itemSize = maxSize
                }
            }
    ) {
        Box(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .padding(start = 10.dp)
                .background(RedColor, RoundedCornerShape(8.dp))
                .height(height)
                .width(58.dp)
                .onGloballyPositioned { coordinates ->
                    minSize = with(density) { coordinates.size.width.toDp() } + 10.dp
                }
                .align(Alignment.CenterEnd)
                .clickable { onDelete() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = null
            )
        }

        Column(
            Modifier
                .clip(RoundedCornerShape(12.dp))
                .padding(end = 8.dp)
                .background(BlueColor, RoundedCornerShape(8.dp))
                .fillMaxHeight()
                .width(58.dp)
                .align(Alignment.CenterStart),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .padding(top = 14.dp)
                    .size(14.dp)
                    .clickable { onPlus() }
            )
            
            Text(
                text = "${item.count}",
                style =
                TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.4.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.White,
                    fontFamily = FontFamily(MyFontFamily)
                )
            )


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(14.dp)
            ) {
                Spacer(modifier = Modifier
                    .width(14.dp)
                    .height(1.dp)
                    .background(Color.White)
                    .border(2.dp, Color.White, CircleShape)
                )
            }

        }

        Row(
            Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(
                    animateDpAsState(
                        targetValue = itemSize,
                        animationSpec = tween(500),
                        label = "Width Animation"
                    ).value
                )
                .align(if (offsetValue > 0f) Alignment.CenterEnd else Alignment.CenterStart)
                .fillMaxHeight()
                .background(Color.White)
                .pointerInput(
                    Unit
                ) {
                    detectHorizontalDragGestures(
                        onDragStart = {
                        },
                        onDragEnd = {
                            itemSize = if (minSize - (maxSize - itemSize) >= minSize / 2) maxSize
                            else maxSize - minSize
                        },
                        onDragCancel = {
                            itemSize = if (minSize - (maxSize - itemSize) >= minSize / 2) maxSize
                            else maxSize - minSize
                        }
                    ) { _, dragAmount ->
                        offsetValue += dragAmount
                        val redactSize = with(density) { offsetValue.toDp() }

                        if (offsetValue < 0f) {
                            if (redactSize + maxSize >= maxSize - minSize) {
                                itemSize = redactSize + maxSize
                            } else {
                                offsetValue -= dragAmount
                            }
                        } else {
                            if (maxSize - redactSize >= maxSize - minSize) {
                                itemSize = maxSize - redactSize
                            } else {
                                offsetValue -= dragAmount
                            }
                        }

                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(9.dp))
            Box(
                Modifier
                    .padding(vertical = 9.dp)
                    .size(85.dp)
                    .background(LightGrayColor, RoundedCornerShape(8.dp))
                    .fillMaxHeight()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = item.image,
                    contentDescription = null,
                    modifier = Modifier
                        .height(36.2.dp)
                )
            }
            Spacer(modifier = Modifier.width(30.dp))

            Column {
                Text(
                    text = item.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )
                
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "₽${item.price}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(500),
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(MyFontFamily),
                        color = Color.Black
                    )
                )
            }

        }
    }
}