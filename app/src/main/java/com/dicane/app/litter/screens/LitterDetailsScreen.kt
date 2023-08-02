package com.dicane.app.litter.screens

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicane.app.R
import com.dicane.app.buy.BuyActivity
import com.dicane.app.compose.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LitterDetailsScreen(context: Context) {
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
                TextTitle(text = "Características físicas")
                TextDefault(text = "Faixa de peso quando adulto: 30kg - 50kg")
                TextDefault(text = "Faixa de altura quando adulto: 50cm - 70cm de cernelha (ombro do cachorro)")
                TextDefault(text = "Solta pêlo: Moderadamente")

                SpaceMedium()
                TextTitle(text = "O criador garante")
                TextDefault(text = "Os cães virão vermifugados")
                TextDefault(text = "Vacinas V10, raiva")
                TextDefault(text = "Envio aéreo")
                TextDefault(text = "Pedigree")
                TextDefault(text = "Microchip")

                SpaceMedium()
                TextTitle(text = "Quando chega até você")
                TextDefault(text = "Previsão de nascimento: 10/10/2023")
                TextDefault(text = "Estarão prontos com 45 dias de vida")
                TextDefault(text = "Previsão de envio: 25/11/2023")
                TextDefault(text = "Previsão de chegada: 27/11/2023")

                SpaceMedium()
                TextTitle(text = "Quantidade de filhotes")
                TextDefault(text = "Previsão de quantidade de filhotes: 10")
                TextDefault(text = "Quantidade confirmada por ultra-som: 10")

                SpaceMedium()
                TextTitle(text = "Prioridade de escolha")
                GreenTextCard(modifier = Modifier, text = "Existe uma prioridade de escolha dos filhotes. \n\nSe você comprar a prioridade 1, você pode escolher qualquer filhote da ninhada. \n\nSe você comprar a prioridade 2, uma pessoa ja terá escolhido um dos filhotes. \n\nSe comprar a 3, duas pessoas já terão escolhido antes de você, e assim por diante.")

                SpaceMedium()
                Divider()
                PriorityReservation("R$ 10.000,00", "Prioridade 1", sold = true ) {
                    BuyActivity.startActivity(context)
                }
                Divider()
                PriorityReservation("R$ 8.000,00", "Prioridade 2" ) {
                    BuyActivity.startActivity(context)
                }
                Divider()
                PriorityReservation("R$ 6.000,00", "Sem prioridade. \n3 disponíveis!" ) {
                    BuyActivity.startActivity(context)
                }
            }
        }
    }
}