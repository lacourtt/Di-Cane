package com.dicane.app.dog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dicane.app.dog.screens.DogDetailsScreen
import com.dicane.app.ui.theme.DiCaneTheme

class DogDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            DiCaneTheme {
                DogDetailsScreen(context)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    val context = LocalContext.current
    DiCaneTheme {
        DogDetailsScreen(context)
    }
}