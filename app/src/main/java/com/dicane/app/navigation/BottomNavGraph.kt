package com.dicane.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dicane.app.AccountScreen
import com.dicane.app.ui.theme.FavoritesScreen
import com.dicane.app.ui.theme.HomeScreen
import com.dicane.app.ui.theme.ReservationsScreen

@Composable
fun BottomNavGraph(modifier: Modifier, navController: NavHostController) {

 NavHost(
     modifier = modifier,
     navController = navController,
     startDestination = BottomBarScreen.Home.route
 ) {
    composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.Favorites.route) {
            FavoritesScreen()
        }
        composable(BottomBarScreen.Reservations.route) {
            ReservationsScreen()
        }
        composable(BottomBarScreen.Account.route) {
            AccountScreen()
        }
 }
}