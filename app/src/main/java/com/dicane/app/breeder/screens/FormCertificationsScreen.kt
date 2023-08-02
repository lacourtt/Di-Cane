package com.dicane.app.breeder.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dicane.app.compose.TextTitleLarge

@Composable
fun FormCertificationsScreen() {
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center) {
        Surface(modifier = Modifier.fillMaxSize()) {
            TextTitleLarge(text = "Certifications")
        }
    }
}