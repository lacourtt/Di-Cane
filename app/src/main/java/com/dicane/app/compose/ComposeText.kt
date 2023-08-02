package com.dicane.app.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.dicane.app.ui.theme.raleway_bold
import com.dicane.app.ui.theme.raleway_regular
import com.dicane.app.ui.theme.roboto_regular

@Composable
fun TextTitle(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = raleway_bold,
            fontSize = 16.sp
        )
    )
    SpaceSmall()
}

@Composable
fun TextTitleLarge(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = raleway_bold,
            fontSize = 20.sp
        )
    )
    SpaceSmall()
}

@Composable
fun TextDefault(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = roboto_regular,
            fontSize = 14.sp,
            color = Color.Black
        )
    )
    SpaceSmall()
}

@Composable
fun TextBoldGreen(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = raleway_bold,
            fontSize = 13.sp,
            color = Color(0xFF00B93E)
        )
    )
    SpaceSmall()
}

@Composable
fun TextDefaultThin(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = raleway_regular,
            fontSize = 16.sp,
            color =  Color.Black
        )
    )
    SpaceSmall()
}

@Composable
fun TextHighLightBlack(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = raleway_bold,
            fontSize = 16.sp
        )
    )
    SpaceSmall()
}