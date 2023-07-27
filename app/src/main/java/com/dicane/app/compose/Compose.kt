package com.dicane.app.compose

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicane.app.LitterDetailsActivity
import com.dicane.app.R
import com.dicane.app.ui.theme.*
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesPager() {
    val images = listOf(
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(34.dp)
    ) {
        val pagerState = rememberPagerState(images.size)

        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(id = R.color.onPrimary),
            elevation = 8.dp
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
                    Text(
                        text = "Ninhada de Golden Retriever",
                        style = TextStyle(
                            fontFamily = raleway_bold,
                            fontSize = 20.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = " Envio aéreo para todo o Brasil",
                        style = TextStyle(
                            fontFamily = raleway_bold,
                            fontSize = 12.sp,
                            color = Color(0xFF00B93E)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = " Previsão de nasimento: 10/10/2023",
                        style = TextStyle(
                            fontFamily = raleway_bold,
                            fontSize = 12.sp,
                            color = Color(0xFF00B93E)
                        )
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Row() {
                        Text(
                            text = " Filhotes a partir de ",
                            style = TextStyle(
                                fontFamily = raleway_regular,
                                fontSize = 16.sp,
                                color = Color(0xFF707070)
                            )
                        )
                        Text(
                            text = "R$ 7.000,00",
                            style = TextStyle(
                                fontFamily = raleway_bold,
                                fontSize = 16.sp
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
fun ActionButton(text: String, onClick: () -> Unit = {}) {
    Button(onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.primaryContainer),
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Text(text = text, style = TextStyle(
            fontFamily = nanum_extrabold,
            fontSize = 20.sp
        )
        )
    }
}

@Composable
fun DefaultCardText(text: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(id = R.color.tertiaryContainer),
        ) {
            Text(text = text,
                style = TextStyle(
                    fontFamily = raleway_regular,
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Composable
fun TextSansSerif(text: String) {
    Text(text = text,
        style = TextStyle(
            fontFamily = roboto_regular,
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun SpaceDefault() {
    Spacer(modifier = Modifier.height(16.dp))
}