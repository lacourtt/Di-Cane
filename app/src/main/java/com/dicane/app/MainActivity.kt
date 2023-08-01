package com.dicane.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dicane.app.compose.*
import com.dicane.app.navigation.BottomNavGraph
import com.dicane.app.ui.theme.DiCaneTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiCaneTheme(darkTheme = false) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        BottomNavGraph(modifier = Modifier.padding(it), navController = navController)
    }
}

@Composable
fun SearchDogTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Box(
        Modifier
            .padding(horizontal = 24.dp, vertical = 12.dp)
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
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.onPrimary)),
            shape = RoundedCornerShape(8.dp),
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiCaneTheme {
        ImagesPager()
    }
}