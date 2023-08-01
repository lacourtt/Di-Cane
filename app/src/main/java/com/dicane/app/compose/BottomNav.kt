package com.dicane.app.compose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.R
import com.dicane.app.navigation.BottomBarScreen
import com.dicane.app.navigation.BottomBarScreen.Home
import com.dicane.app.navigation.BottomBarScreen.Favorites
import com.dicane.app.navigation.BottomBarScreen.Reservations
import com.dicane.app.navigation.BottomBarScreen.Account

@Composable
fun BottomNav(navHostController: NavHostController) {
    val screensList = listOf(
        Home, Favorites, Reservations, Account
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.onPrimary),
        elevation = 6.dp,
    ) {
        // this is a row scope
        // all items are added horizontally
        screensList.forEach { screen ->
            AddItem(screen, currentDestination, navHostController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
) {
    BottomNavigationItem(
        label = {Text(text = screen.title)},
        icon = {Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")},
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route)
        })
}