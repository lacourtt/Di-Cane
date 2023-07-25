package com.dicane.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnitType.Companion.Sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicane.app.ui.theme.DiCaneTheme
import com.google.accompanist.pager.HorizontalPagerIndicator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiCaneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scrollState = rememberScrollState()
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(enabled = true, state = scrollState)
                    )   {
                        Column {
                            SearchDogTextField()
                            FeaturedPager()
                            CardText()
                            BecomeBreederButton()
                            Carousel("Mais vendidos")
                            Carousel("Mais procurados")
                        }
                    }
                }
            }
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
    TextSansSerif(text = title)
    LazyRow {
        items(placeholderImageIds) { imageId ->
            CardImage(imageId)
        }
    }
}

@Composable
fun TextSansSerif(text: String) {
    Text(text = text,
        style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun CardImage(imageId: Int) {
    Box(Modifier.padding(8.dp)) {
        Card(
            Modifier
                .width(100.dp)
                .height(150.dp)){
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
fun BecomeBreederButton() {
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.primaryContainer),
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Text(text = "Seja um criador Di Cane", style = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp
        ))
    }
}
@Composable
fun SearchDogTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Box(
        Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        OutlinedTextField(
            placeholder = { Text(text = "Pesquisar raça") },
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search_grey),
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturedPager() {
    val images = listOf(
        R.drawable.corso,
        R.drawable.puppy,
        R.drawable.pitcorso,
    )
    val pagerState = rememberPagerState()
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
    ) {
        HorizontalPager(pageCount = images.size, state = pagerState) {
            Image(
                painter = painterResource(id = images[it]),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(400.dp)
                    .height(200.dp),
                contentDescription = "" )
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            pageCount = images.size,
            pagerState = pagerState,
        )
    }

}

@Composable
fun CardText() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = colorResource(id = R.color.tertiaryContainer),
        ) {
            Text(text = "Garantimos alta qualidade e confiabilidade para nossos compradores.",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiCaneTheme {
        FeaturedPager()
    }
}