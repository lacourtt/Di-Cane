package com.dicane.app.buy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dicane.app.compose.ActionButton
import com.dicane.app.compose.TextDefault
import com.dicane.app.ui.theme.DiCaneTheme

class BuyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiCaneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scrollState = rememberScrollState()
                    Column(
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(enabled = true, state = scrollState)
                    ) {
                        Text(text = "Filhotes disponíveis: 3")
                        TextDefault(text = "Escolha antes dos outros compradores!")
                        ActionButton(text = "Reservar segunda escolha por R$ 8.000")
                        TextDefault(text = "Reservar sem prioridade")
                        ActionButton(text = "Reservar por R$ 6.000")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    DiCaneTheme {
        Greeting3("Android")
    }
}