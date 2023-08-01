package com.dicane.app.compose

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpaceSmall() {
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun SpaceMedium() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpaceLarge() {
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SpaceExtraLarge(text: String) {
    Spacer(modifier = Modifier.height(32.dp))
}