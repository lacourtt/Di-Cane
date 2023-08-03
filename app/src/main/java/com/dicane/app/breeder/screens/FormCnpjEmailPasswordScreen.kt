package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.compose.*

@Composable
fun FormCnpjEmailPasswordScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 45.dp, vertical = 16.dp)
        ) {
            TextDefaultThin(text = "CNPJ")
            CNPJTextField(hint = "Insira seu CNPJ de criador")
            SpaceMedium()

            TextDefaultThin(text = "Email")
            DefaultTextField(hint = "Insira seu melhor email")
            SpaceMedium()

            TextDefaultThin(text = "Senha")
            PasswordTextField(hint = "Insira sua senha")
            SpaceMedium()

            PasswordTextField(hint = "Confirme a senha")

            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ActionButtonWhite(
                    Modifier.align(Alignment.BottomCenter),
                    text = "Próximo"
                ) {
                    navController.navigate(BreederScreen.FormNamePicDesc.route)
                }
            }

        }
    }
}