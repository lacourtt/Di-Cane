package com.dicane.app.compose

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicane.app.R
import com.dicane.app.litter.LitterDetailsActivity
import com.dicane.app.ui.theme.*
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.android.material.R as MR

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SaleCard(click: () -> Unit = {}) {
    val images = listOf(
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .defaultBottomPadding()
    ) {
        val pagerState = rememberPagerState(images.size)
        Card(
            Modifier.clickable { click() },
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(id = R.color.onPrimary),
            //elevation = 5.dp
        ) {
            Column {
                Box(contentAlignment = Alignment.Center) {
                    HorizontalPager(
                        pageCount = images.size,
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                    ) {
                        Image(
                            painter = painterResource(id = images[it]),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth(),
                            contentDescription = "",

                        )
                    }
                    HorizontalPagerIndicator(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 10.dp),
                        pageCount = images.size,
                        pagerState = pagerState,
                        activeColor = Color.White,
                    )
                    Box(modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                    ) {
                        FavoriteButton()
                    }
                }

                Column(Modifier.padding(16.dp)) {
                    TextTitle(text = "Ninhada de Golden Retriever")
                    TextBoldGreen(text = " Envio aéreo para todo o Brasil")
                    TextBoldGreen(text = " Previsão de nascimento: 10/10/2023")
                    Row {
                        TextDefaultThin(text = " Filhotes a partir de ")
                        TextHighLightBlack(text = "R$ 7.000,00")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesPager(images: List<Int>, pagerState: PagerState) {
    HorizontalPager(
        pageCount = images.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
    ) {
        Box {
            Image(
                painter = painterResource(id = images[it]),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentDescription = "",
            )
            Box(
                Modifier
                    .padding(10.dp)
                    .size(width = 40.dp, height = 25.dp)
                    .align(Alignment.BottomEnd),
            ){
                Surface(
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    color = Color(0x86000000)
                ) {
                    Box {
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center),
                            text = "${it+1}/${images.size}",
                            style = TextStyle(
                                fontFamily = roboto_regular,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63)
) {

    var isFavorite by remember { mutableStateOf(false) }

    Surface(
        shape = CircleShape,
        modifier = Modifier
            .size(40.dp),
        color = Color(0x48000000)
    ){
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = {
                isFavorite = !isFavorite
            }
        ) {
            Icon(
                tint = color,
                modifier = modifier.graphicsLayer {
                    scaleX = 1.3f
                    scaleY = 1.3f
                },
                imageVector = if (isFavorite) {
                    Icons.Filled.Favorite
                } else {
                    Icons.Default.FavoriteBorder
                },
                contentDescription = null
            )
        }
    }


}

@Composable
fun Carousel(title: String) {
    val placeholderImageIds = listOf(
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
        R.drawable.corso,
    )
    Text(text = title)
    LazyRow {
        items(placeholderImageIds) { imageId ->
            CardImage(
                imageId, )
        }
    }
}

@Composable
fun CardImage(imageId: Int) {
    val context = LocalContext.current
    Box(Modifier.padding(8.dp)) {
        Card(
            Modifier
                .width(100.dp)
                .height(150.dp)
                .clickable {
                    context.startActivity(
                        Intent(
                            context,
                            LitterDetailsActivity::class.java
                        )
                    )
                },
        ){
            Image(
                bitmap = ImageBitmap.imageResource(id = imageId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun GreenTextCard(modifier: Modifier = Modifier.defaultBottomPadding(), text: String) {
    Box(modifier = modifier.fillMaxWidth()) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(id = R.color.tertiaryContainer),
        ) {
            TextDefault(Modifier.padding(10.dp), text = text)
        }
    }

}

@Composable
fun PriorityReservation(price: String, priority: String, sold: Boolean = false, onClick: () -> Unit = {}) {
    Row(
        Modifier.padding(vertical = 7.dp)
    ){
        Column(Modifier.weight(5f)) {
            TextTitle(text = price)
            TextDefaultThin(text = priority)
        }

        val modifier = Modifier
            .weight(5f)

        if (sold) {
            ActionButtonOff(
                modifier = modifier,
                text = "Vendido",
            ) { }
        } else {
            ActionButtonBlue(
                modifier = modifier,
                text = "Reservar",
            ) {
                onClick()
            }
        }
    }
}

fun Modifier.defaultBottomPadding() = this.padding(bottom = 14.dp)

