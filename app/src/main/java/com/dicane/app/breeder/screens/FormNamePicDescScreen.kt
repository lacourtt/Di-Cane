package com.dicane.app.breeder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.R
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.camera.CameraActivity
import com.dicane.app.compose.*

@Composable
fun FormNamePicDescScreen(navController: NavHostController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.corso),
                    contentDescription = null,
                    modifier = Modifier.clip(CircleShape),//.size(10.dp),
                    contentScale = ContentScale.Crop
                )
            }

            TextDefaultThin(text = "Nome")
            DefaultTextField(hint = "Insira o nome do canil")
            SpaceMedium()

            TextDefaultThin(text = "Descrição")
            DefaultTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                hint = "Insira uma breve descrição do seu trabalho como criador",
                singleLine = false
            )
            SpaceMedium()

            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ActionButtonBlue(
                    Modifier.align(Alignment.BottomCenter),
                    text = "Próximo"
                ) {
                    navController.navigate(BreederScreen.FormPhoto.route)
                }
            }

        }
    }
}