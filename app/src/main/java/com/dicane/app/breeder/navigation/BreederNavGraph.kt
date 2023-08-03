package com.dicane.app.breeder.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dicane.app.breeder.screens.*

@Composable
fun BreederNavGraph(modifier: Modifier, navController: NavHostController, isLogged: Boolean = false) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = if (isLogged) BreederScreen.BreederHome.route
        else BreederScreen.FormCnpjEmailPassword.route
    ) {
        composable(BreederScreen.BreederHome.route){
            BreederHomeScreen(navController)
        }
        composable(BreederScreen.FormCnpjEmailPassword.route){
            FormCnpjEmailPasswordScreen(navController)
        }
        composable(BreederScreen.FormNamePicDesc.route){
            FormNamePicDescScreen(navController)
        }
        composable(BreederScreen.FormCertifications.route){
            FormCertificationsScreen(navController)
        }
        composable(BreederScreen.FormAwards.route){
            FormAwardsScreen(navController)
        }
    }
}