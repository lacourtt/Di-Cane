package com.dicane.app.home.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.dicane.app.R
import com.dicane.app.breeder.BreederHomeActivity
import com.dicane.app.compose.*
import com.dicane.app.dog.DogDetailsActivity
import com.dicane.app.litter.LitterDetailsActivity

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(enabled = true, state = scrollState)
            .background(color = colorResource(id = R.color.surfaceVariant))
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        SearchDogTextField()
        thisPageDivider()
        GreenTextCard(
            text = "Garantimos alta qualidade e confiabilidade para nossos compradores."
        )
        ActionButtonDark(modifier = Modifier.fillMaxWidth(), text = "Seja um criador Di Cane") {
            BreederHomeActivity.startActivity(context)
        }
        thisPageDivider()
        SaleCard{
            startLitterDetailsActivity(context)
        }
        SaleCard{startDogDetailsActivity(context)}
        SaleCard{startDogDetailsActivity(context)}
    }
}

@Composable
fun thisPageDivider() {
    SpaceMedium()
    Divider()
    SpaceMedium()
}

fun startDogDetailsActivity(context: Context) {
    context.startActivity(Intent(context, DogDetailsActivity::class.java))
}
fun startLitterDetailsActivity(context: Context) {
    context.startActivity(Intent(context, LitterDetailsActivity::class.java))
}