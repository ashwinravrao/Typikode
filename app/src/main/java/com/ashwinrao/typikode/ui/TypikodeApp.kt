package com.ashwinrao.typikode.ui

import androidx.compose.runtime.Composable
import com.ashwinrao.typikode.navigation.TypikodeNavigationHost
import com.ashwinrao.typikode.ui.theme.TypikodeTheme

@Composable
fun TypikodeApp() {
    TypikodeTheme {
        TypikodeNavigationHost()
    }
}