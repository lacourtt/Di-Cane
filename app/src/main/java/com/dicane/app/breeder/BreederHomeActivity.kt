package com.dicane.app.breeder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dicane.app.breeder.navigation.BreederNavGraph
import com.dicane.app.breeder.screens.FormNamePicDescScreen
import com.dicane.app.buy.BuyActivity
import com.dicane.app.ui.theme.DiCaneTheme

class BreederHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiCaneTheme {
                BreederMainScreen()
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, BreederHomeActivity::class.java)
            context.startActivity(intent)
        }
    }
}

@Composable
fun BreederMainScreen() {
    val navController = rememberNavController()
    Scaffold() {
        FormNamePicDescScreen(navController)
        BreederNavGraph(modifier = Modifier.padding(it), navController = navController)
    }
}
@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    DiCaneTheme {
        Greeting2("Android")
    }
}