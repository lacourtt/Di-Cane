package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.compose.TextTitleLarge

@Composable
fun FormCertificationsScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TextTitleLarge(text = "FormCertificationsScreen")
            Button(
                onClick = {
                    navController.navigate(BreederScreen.FormAwards.route)
                }
            ) {
                TextTitleLarge(text = "Next")
            }
        }
    }

}