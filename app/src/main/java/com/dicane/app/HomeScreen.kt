package com.dicane.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.dicane.app.compose.ActionButton
import com.dicane.app.compose.DefaultCardText
import com.dicane.app.compose.ImagesPager

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
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
}