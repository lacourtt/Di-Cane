package com.dicane.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.dicane.app.buy.BuyActivity
import com.dicane.app.compose.ActionButton
import com.dicane.app.compose.DefaultCardText
import com.dicane.app.compose.ImagesPager
import com.dicane.app.compose.TextSansSerif
import com.dicane.app.ui.theme.DiCaneTheme

class LitterDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            DiCaneTheme {
                // A surface container using the 'background' color from the theme
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
                        TextSansSerif(text = "Conheça os pais da ninhada")
                        ImagesPager()
                        TextSansSerif(text = "Previsão de nascimento: 10/10/2023")
                        TextSansSerif(text = "Estarão prontos com 45 dias de vida")
                        TextSansSerif(text = "Previsão de envio: 25/11/2023")
                        TextSansSerif(text = "Tipo de envio: aéreo")
                        TextSansSerif(text = "Os cães virão vermifugados")
                        TextSansSerif(text = "Vacinados com: V10, raiva")
                        TextSansSerif(text = "Pedigree: sim")
                        TextSansSerif(text = "Microchip: sim")
                        DefaultCardText(text = "Existe uma prioridade de escolha dos filhotes. Se você comprar a prioridade 1, você pode escolher qualquer filhote da ninhada. Se você comprar a prioridade 2, você terá alguém ja terá escolhido um dos filhotes. Se comprar a 3, 2 pessoas já terão escolhido antes de você, e assim por diante.")
                        TextSansSerif(text = "Prioridade 1: R$ 10.000,00 (COMPRADO)")
                        TextSansSerif(text = "Prioridade 2: R$ 8.000,00 (DISPONÍVEL)")
                        TextSansSerif(text = "Prioridade 3: R$ 7.000,00 (COMPRADO)")
                        TextSansSerif(text = "O restante dos filhotes serão vendidos por R$ 6.000,00 (2 RESTANTES)")
                        TextSansSerif(text = "Previsão de quantidade de filhotes: 10")
                        TextSansSerif(text = "Quantidade confirmada por ultra-som: 10")

                        ActionButton(text = "Reservar meu filhote") {
                            startActivity(Intent(context, BuyActivity::class.java))
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    DiCaneTheme {
        Greeting("Android")
    }
}