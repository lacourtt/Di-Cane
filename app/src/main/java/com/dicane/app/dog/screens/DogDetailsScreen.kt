package com.dicane.app.dog.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicane.app.R
import com.dicane.app.buy.BuyActivity
import com.dicane.app.compose.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DogDetailsScreen(context: Context) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val scrollState = rememberScrollState()
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(enabled = true, state = scrollState)
        ) {
            val images = listOf(
                R.drawable.corso,
                R.drawable.puppy,
                R.drawable.pitcorso,
            )
            val pagerState = rememberPagerState(images.size)
            ImagesPager(images = images, pagerState = pagerState)

            Column(modifier = Modifier
                .padding(horizontal = 24.dp)
            ) {
                SpaceMedium()
                TextTitleLarge(text = "Cane Corso")
                TextDefault(text = "Nascido em: 10/10/2023")
                TextDefault(text = "3 meses de vida")
                TextDefault(text = "Ninhada de Cratus e Hera")

                SpaceMedium()
                TextTitleLarge(text = "Características do filhote")
                SpaceSmall()
                TextTitle(text = "Com quem o filhote se dá bem")
                TextDefault(text = "Dócil com adultos")
                TextDefault(text = "Dócil com crianças")
                TextDefault(text = "Reativo com outros cães")
                TextDefault(text = "Reativo com gatos")

                SpaceMedium()
                TextTitle(text = "Função pricipal")
                TextDefault(text = "Cão perfeito para guarda")

                SpaceMedium()
                TextTitle(text = "Quando chega até você")
                TextDefault(text = "Previsão de envio: 25/11/2023")
                TextDefault(text = "Previsão de chegada: 27/11/2023")

                SpaceMedium()
                TextTitle(text = "O criador garante")
                TextDefault(text = "Virá vermifugado")
                TextDefault(text = "Vacinas V10, raiva")
                TextDefault(text = "Envio aéreo")
                TextDefault(text = "Pedigree")
                TextDefault(text = "Microchip")

                SpaceMedium()
                TextTitle(text = "Características físicas")
                TextDefault(text = "Faixa de peso quando adulto: 30kg - 50kg")
                TextDefault(text = "Faixa de altura quando adulto: 50cm - 70cm de cernelha (ombro do cachorro)")
                TextDefault(text = "Solta pêlo: Moderadamente")
                TextDefault(text = "Suporta clima quente: Sim")
                TextDefault(text = "Suporta clima frio: Sim")

                SpaceMedium()
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center) {
                    ActionButtonBlue(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Comprar filhote"
                    )  {
                        BuyActivity.startActivity(context)
                    }
                }
                SpaceMedium()
            }
        }
    }
}