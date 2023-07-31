package com.dicane.app.compose

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext

@Composable
fun BottomNav() {
    // items list
    val bottomMenuItemsList = BottomMenuItem.prepareBottomMenu()

    val contextForToast = LocalContext.current.applicationContext

    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomNavigation {
        // this is a row scope
        // all items are added horizontally
        bottomMenuItemsList.forEach { menuItem ->
            // adding each item
            BottomNavigationItem(
                selected = (selectedItem == menuItem.label),
                onClick = {
                    selectedItem = menuItem.label
                    Toast.makeText(
                        contextForToast,
                        menuItem.label, Toast.LENGTH_SHORT
                    ).show()
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                label = {
                    Text(text = menuItem.label)
                },
                enabled = true,
            )
        }
    }
}

data class BottomMenuItem(val label: String, val icon: ImageVector) {
    companion object {
        fun prepareBottomMenu(): List<BottomMenuItem> {
            val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

            // add menu items
            bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = Icons.Filled.Home))
            bottomMenuItemsList.add(BottomMenuItem(label = "Favoritos", icon = Icons.Filled.Favorite))
            bottomMenuItemsList.add(BottomMenuItem(label = "Reservas", icon = Icons.Filled.ShoppingCart))
            bottomMenuItemsList.add(BottomMenuItem(label = "Sua Conta", icon = Icons.Filled.Person))

            return bottomMenuItemsList
        }
    }
}