package com.dicane.app.home.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home
    )
    object Favorites : BottomBarScreen(
        route = "favorites",
        title = "Favoritos",
        icon = Icons.Filled.Favorite
    )
    object Reservations : BottomBarScreen(
        route = "reservations",
        title = "Reservas",
        icon = Icons.Filled.ShoppingCart
    )
    object Account : BottomBarScreen(
        route = "account",
        title = "Conta",
        icon = Icons.Filled.Person
    )
}
