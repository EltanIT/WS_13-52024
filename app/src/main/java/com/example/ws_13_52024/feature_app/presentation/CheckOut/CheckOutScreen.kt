package com.example.ws_13_52024.feature_app.presentation.CheckOut

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.ws_13_52024.R
import com.example.ws_13_52024.core.presentation.CustomBackImage
import com.example.ws_13_52024.core.presentation.CustomPrimaryButton
import com.example.ws_13_52024.feature_app.presentation.Card.CardEvent
import com.example.ws_13_52024.feature_app.presentation.ui.theme.DarkGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.GrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.LightGrayColor
import com.example.ws_13_52024.feature_app.presentation.ui.theme.MyFontFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun CheckOutScreen(
    navController: NavController,
    viewModel: CheckOutViewModel = koinViewModel()
) {

    val state = viewModel.state.value


    Column(
        Modifier
            .fillMaxSize()
            .background(LightGrayColor)
    ) {
        Box(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            CustomBackImage(
                color = Color.White,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(Alignment.CenterStart)
            ) {
                navController.popBackStack()
            }

            Text(
                text = "My Cart",
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
        Spacer(modifier = Modifier.height(46.dp))


        Column(
            Modifier.padding(horizontal = 14.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Контактная информация", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(
                        MyFontFamily
                    )
                ),
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_email_card), contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = state.profile?.email ?: "*****************@*******.***", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = Color.Black
                        ),
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Email", style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = DarkGrayColor
                        )
                    )
                }
                Spacer(modifier = Modifier.width(11.dp))
                Image(painter = painterResource(id = R.drawable.ic_redact), contentDescription = null)
            }
            
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_phone), contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = state.profile?.phone ?: "+***-***-***-****", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = Color.Black
                        ),
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Телефон", style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = DarkGrayColor
                        )
                    )
                }
                Spacer(modifier = Modifier.width(11.dp))
                Image(painter = painterResource(id = R.drawable.ic_redact), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(12.dp))


            Text(
                text = "Адрес", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(
                        MyFontFamily
                    ),
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 20.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            
            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "1082 Аэропорт, Нигерии", style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = FontFamily(
                            MyFontFamily
                        ),
                        color = DarkGrayColor
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )
                
                Image(painter = painterResource(id = R.drawable.ic_frame), contentDescription = null)
            }


            Spacer(modifier = Modifier.height(16.dp))


            Box(
                Modifier
                    .padding(horizontal = 20.dp)
                    .height(101.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = "https://s3-alpha-sig.figma.com/img/ccd6/558c/e7b344891875b7f970b634557845cf05?Expires=1716768000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=KBhEzQKrCnbn9r8fkso0WzTVJ~6MVA2qzfr6ZPahUqyFLXaLJuVRzDyRz-mgpeMVv~gNjfEB9icJYHjdSQCvVK488AcEqZDPu9BbY0VgUVseR-4fd0RdpPDUJYOwmDliWdyefG86PClcCJf7gL8RzaPpP2R-sQVCdglOG1coMNI4I-SYlAxiv35HnpVrABzYReyZYSsYmUMZNcK62AD1GEZcKSX0bK29ECvS2ZSpd-OwMzcW5opafel8mBIPKfSjAWuPCEETSjaAU5GHkqTkyvBZDjveg1D4-dfo9M5Wj5CoDudCT53qNXyunrDpuIvaMN7hM5wYtVDtb7mdlGuafQ__",
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Посмотреть на карте",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 23.sp,
                            fontWeight = FontWeight(700),
                            fontFamily = FontFamily(MyFontFamily)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Image(painter = painterResource(id = R.drawable.ic_location), contentDescription = null)
                }

            }
            
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Способ оплаты", style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(
                        MyFontFamily
                    ),
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))


            Row(
                Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_bank),
                    contentDescription = null,
                    Modifier.size(40.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    Modifier.weight(1f)
                ) {
                    Text(
                        text = if (state.profile == null) "Добавить" else "DbL Card", style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = Color.Black
                        ),
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = state.profile?.card ?: "**** ****", style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = FontFamily(
                                MyFontFamily
                            ),
                            color = DarkGrayColor
                        )
                    )
                }
            }
        }
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
                onClick = { viewModel.onEvent(CheckOutEvent.Send) },
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}