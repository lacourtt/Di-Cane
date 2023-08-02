package com.dicane.app.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicane.app.R
import com.dicane.app.ui.theme.roboto_regular

enum class ButtonType {
    DARK,
    BLUE,
    WHITE,
    OFF
}

@Composable
fun ActionButtonBlue(
    modifier: Modifier = Modifier.defaultBottomPadding(),
    text: String,
    onClick: () -> Unit = {}
) {
    ActionButton(modifier = modifier, text = text, buttonType = ButtonType.BLUE, onClick = onClick)
}

@Composable
fun ActionButtonDark(
    modifier: Modifier = Modifier.defaultBottomPadding(),
    text: String,
    onClick: () -> Unit = {}
) {
    ActionButton(modifier = modifier, text = text, buttonType = ButtonType.DARK, onClick = onClick)
}

@Composable
fun ActionButtonOff(
    modifier: Modifier = Modifier.defaultBottomPadding(),
    text: String,
    onClick: () -> Unit = {}
) {
    ActionButton(modifier = modifier, text = text, buttonType = ButtonType.OFF, onClick = onClick)
}

@Composable
fun ActionButtonWhite(
    modifier: Modifier = Modifier.defaultBottomPadding(),
    text: String,
    onClick: () -> Unit = {}
) {
    ActionButton(modifier = modifier, text = text, buttonType = ButtonType.WHITE, onClick = onClick)
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier.defaultBottomPadding(),
    text: String,
    buttonType: ButtonType,
    onClick: () -> Unit = {}
) {

    var border: BorderStroke? = null
    var shape: Shape? = null

    val colors = when(buttonType) {
        ButtonType.DARK -> {
            ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.accentBlack),
                contentColor = Color.White
            )
        }
        ButtonType.BLUE -> {
            ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.accentBlue),
                contentColor = Color.White
            )
        }
        ButtonType.WHITE -> {
            border = BorderStroke(1.dp, Color.Black)
            shape = RoundedCornerShape(8.dp)
            ButtonDefaults.buttonColors(
                backgroundColor = Color.White,
                contentColor = Color.Black
            )
        }
        ButtonType.OFF -> {
            ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.White
            )
        }
    }
    Button(
        onClick = { onClick() },
        colors = colors,
        shape = shape ?: RoundedCornerShape(20.dp),
        border = border,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = roboto_regular,
                fontSize = 18.sp)
        )
    }
}