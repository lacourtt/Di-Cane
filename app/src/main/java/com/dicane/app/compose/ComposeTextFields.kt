package com.dicane.app.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dicane.app.compose.MaskTransformation.MaskType.CNPJ
import com.dicane.app.ui.theme.roboto_regular
import com.google.android.material.R

@Composable
fun CNPJTextField(modifier: Modifier? = null, hint: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    val pattern = remember { Regex("^\\d+\$") }

    OutlinedTextField(
        modifier = modifier ?: defaultModifier(),
        shape = RoundedCornerShape(8.dp),
        value = text,
        placeholder = {TextSmallGray(text = hint)},
        onValueChange =
        { it
            if (it.text.length <= CNPJ.count && it.text.matches(pattern)) {
                text = it
            }
        },
        visualTransformation = MaskTransformation(CNPJ.mask),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
        ),
        singleLine = true,
        textStyle = defaultTextStyle(),
        colors = defaultTextFieldColors(),
    )
}

@Composable
fun DefaultTextField(modifier: Modifier? = null, hint: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        modifier = modifier ?: defaultModifier(),
        shape = RoundedCornerShape(8.dp),
        value = text,
        placeholder = {TextSmallGray(text = hint)},
        onValueChange = { text = it },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
        ),
        singleLine = true,
        textStyle = defaultTextStyle(),
        colors = defaultTextFieldColors(),
    )
}

@Composable
fun PasswordTextField(modifier: Modifier? = null, hint: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier ?: defaultModifier(),
        shape = RoundedCornerShape(8.dp),
        value = text,
        placeholder = {TextSmallGray(text = hint)},
        onValueChange = { text = it },
        textStyle = defaultTextStyle(),
        colors = defaultTextFieldColors(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
        ),
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = if (isPasswordVisible)
                            R.drawable.design_ic_visibility
                        else R.drawable.design_ic_visibility_off
                    ),
                    contentDescription = ""
                )
            }
        },
    )
}

@Composable
private fun defaultTextStyle() = TextStyle(
    fontFamily = roboto_regular,
    fontSize = 18.sp,
    color = Color.Black
)

@Composable
private fun defaultTextFieldColors() = TextFieldDefaults.textFieldColors(
    backgroundColor = Color.White,
    focusedIndicatorColor = Color.Gray,
    unfocusedIndicatorColor = Color.Black,
    disabledIndicatorColor = Color.Transparent,
    errorIndicatorColor = Color.Red,
    cursorColor = Color.Black,
)

@Composable
private fun defaultModifier() = Modifier
    .fillMaxWidth()
    .defaultBottomPadding()

@Composable
fun SearchDogTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Box(
        Modifier
            .padding(vertical = 12.dp)
    ) {
        OutlinedTextField(
            placeholder = { Text(text = "Pesquisar raça") },
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = com.dicane.app.R.drawable.ic_search_grey),
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = com.dicane.app.R.color.onPrimary)),
            shape = RoundedCornerShape(8.dp),
        )
    }

}