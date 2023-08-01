package com.dicane.app.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.dicane.app.R
import com.dicane.app.SearchDogTextField
import com.dicane.app.compose.ActionButton
import com.dicane.app.compose.BottomNav
import com.dicane.app.compose.DefaultCardText
import com.dicane.app.compose.ImagesPager
import com.dicane.app.navigation.BottomNavGraph

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNav(navController) }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(enabled = true, state = scrollState)
                .background(color = colorResource(id = R.color.surfaceVariant)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            SearchDogTextField()
            ImagesPager()
            DefaultCardText("Garantimos alta qualidade e confiabilidade para nossos compradores.")
            ActionButton("SEJA UM CRIADOR DI CANE"){
//                startActivity(Intent(this@MainActivity, BreederHomeActivity::class.java))
            }
            ImagesPager()
            ImagesPager()
        }
        BottomNavGraph(Modifier.padding(it), navController = navController)
    }

}