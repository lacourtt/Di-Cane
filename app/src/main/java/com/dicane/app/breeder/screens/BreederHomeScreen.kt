package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.compose.TextTitleLarge

@Composable
fun BreederHomeScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TextTitleLarge(text = "BreederHomeScreen")
            Button(
                onClick = {
//                navController.navigate(BreederScreen.BreederHome.route)
                }
            ) {
                TextTitleLarge(text = "Next")
            }
        }
    }
}