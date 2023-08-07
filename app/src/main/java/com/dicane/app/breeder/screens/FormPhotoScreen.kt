package com.dicane.app.breeder.screens

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dicane.app.breeder.navigation.BreederScreen
import com.dicane.app.camera.CameraActivity
import com.dicane.app.compose.ActionButtonBlue
import com.dicane.app.parcelable

@Composable
fun FormPhotoScreen(navController: NavHostController) {

    val context = LocalContext.current

    val cameraLauncher =  rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
            val data = it.data
            if (it.resultCode == Activity.RESULT_OK) {
                //  you will get result here in result.data
                if (it.data != null) {
                    Toast.makeText(context, "Photo taken Uri = ${data?.parcelable<Uri>("photoUri")}", Toast.LENGTH_SHORT).show()
                    navController.navigate(BreederScreen.FormCnpjEmailPassword.route)
                }
            }
        }
    )

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
                ActionButtonBlue(
                    text = "Tirar foto",
                    onClick = {
                        cameraLauncher.launch(Intent(context, CameraActivity::class.java))
                })
            }
        }
    }
}