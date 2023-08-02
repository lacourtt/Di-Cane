package com.dicane.app.breeder.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dicane.app.breeder.screens.BreederHomeScreen
import com.dicane.app.breeder.screens.FormAwardsScreen
import com.dicane.app.breeder.screens.FormCertificationsScreen
import com.dicane.app.breeder.screens.FormNamePicDescScreen

@Composable
fun BreederNavGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BreederScreen.BreederHome.route
    ) {
        composable(BreederScreen.BreederHome.route){
            BreederHomeScreen()
        }
        composable(BreederScreen.FormNamePicDesc.route){
            FormNamePicDescScreen(navController)
        }
        composable(BreederScreen.FormCertifications.route){
            FormCertificationsScreen()
        }
        composable(BreederScreen.FormAwards.route){
            FormAwardsScreen()
        }
    }
}