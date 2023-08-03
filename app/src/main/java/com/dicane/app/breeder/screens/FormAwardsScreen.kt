package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.compose.TextTitleLarge

@Composable
fun FormAwardsScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TextTitleLarge(text = "FormAwardsScreen")
            Button(
                onClick = {
                    navController.navigate(BreederScreen.BreederHome.route)
                }
            ) {
                TextTitleLarge(text = "Next")
            }
        }
    }

}