package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.compose.TextDefault
import com.dicane.app.compose.TextTitleLarge

@Composable
fun FormInitialMessageScreen(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TextDefault(text = "Que bom você tem o interesse em ser um criador Di Cane! " +
                    "\n\n Antes de mais nada, gostaríamos de informar que mantemos um alto padrão de criadores. Por isso, exigimos o número de CNPJ registrado como criador de animais e uma comprovação de registro na CBKC ou Kennel Club da sua região. " +
                    "\n\n Se você possiu esses requisitos, clique em abaixo em Vamos começar! " +
                    "\n\n Caso contrário não será possível prosseguir com o cadastro.")
            Button(
                onClick = {
                navController.navigate(BreederScreen.FormPhoto.route)
                }
            ) {
                TextTitleLarge(text = "Vamos começar!")
            }
        }
    }
}