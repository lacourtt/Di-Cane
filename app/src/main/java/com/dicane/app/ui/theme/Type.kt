package com.dicane.app.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dicane.app.R

val notoserif_regular = FontFamily(Font(R.font.notoserif_regular))
val notoserif_medium = FontFamily(Font(R.font.notoserif_medium))
val notoserif_bold = FontFamily(Font(R.font.notoserif_bold))

val nanum_extrabold = FontFamily(Font(R.font.nanummyeongjo_extrabold))
val nanum_bold = FontFamily(Font(R.font.nanummyeongjo_bold))
val nanum_regular = FontFamily(Font(R.font.nanummyeongjo_regular))

val raleway_regular = FontFamily(Font(R.font.raleway_regular))
val raleway_bold = FontFamily(Font(R.font.raleway_bold))

val roboto_regular = FontFamily(Font(R.font.roboto_regular))
val roboto_light = FontFamily(Font(R.font.roboto_light))

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)