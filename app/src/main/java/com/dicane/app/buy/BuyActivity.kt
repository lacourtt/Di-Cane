package com.dicane.app.buy

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicane.app.compose.*
import com.dicane.app.ui.theme.DiCaneTheme

class BuyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiCaneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scrollState = rememberScrollState()
                    Column(
                        Modifier
                            .padding(horizontal = 32.dp)
                            .fillMaxSize()
                            .verticalScroll(enabled = true, state = scrollState)
                    ) {
                        SpaceMedium()
                        TextTitleLarge(text = "Informações do seu filhote")
                        TextDefault(text = "- Raça Cane Corso")
                        TextDefault(text = "- Ninhada Cratus x Hera")
                        TextDefault(text = "- Sem prioridade")

                        SpaceMedium()
                        TextTitle(text = "Tipo de envio")
                        TextDefault(text = "Envio aéreo")

                        thisPageDivider()
                        TextTitleLarge(text = "Endereço")
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            TextDefault(text = "Rua dos Bobos, 0")
                            ActionButtonWhite(text = "Alterar")
                        }

                        thisPageDivider()
                        TextTitleLarge(text = "Especificação do valor")
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                horizontalAlignment = Alignment.Start)
                            {
                                TextTitle(text = "Filhote")
                                TextTitle(text = "Frete")
                                TextTitle(text = "Valor total")
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth(0.5f),
                                horizontalAlignment = Alignment.Start)
                            {
                                TextDefault(text = "R$ 6.000")
                                TextDefault(text = " R$ 200")
                                TextTitle(text = " R$ 6.200")
                            }
                        }

                        thisPageDivider()
                        TextTitleLarge(text = "Forma de pagamento")
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            TextDefault(text = "Cartão de crédito")
                            ActionButtonWhite(text = "Alterar")

                        }
                        thisPageDivider()

                        TextTitleLarge(text = "Política de cancelamento")
                        TextDefault(text = "Você pode cancelar a compra até 7 dias antes do envio.")

                        SpaceLarge()
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            ActionButtonBlue(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Concluir compra e pagar"
                            ) {}
                        }
                        SpaceMedium()
                    }
                }
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, BuyActivity::class.java)
            context.startActivity(intent)
        }
    }
}

@Composable
fun thisPageDivider() {
    SpaceMedium()
    Divider()
    SpaceMedium()
}
@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    DiCaneTheme {
        Greeting3("Android")
    }
}