package com.dicane.app.navigation

import android.util.Log
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
fun BottomNavGraph(navController: NavHostController) {

 NavHost(
     navController = navController,
     startDestination = BottomBarScreen.Home.route
 ) {
        composable(BottomBarScreen.Home.route) {
            Log.d("igor", "HomeScreen called")
            HomeScreen(navController)
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