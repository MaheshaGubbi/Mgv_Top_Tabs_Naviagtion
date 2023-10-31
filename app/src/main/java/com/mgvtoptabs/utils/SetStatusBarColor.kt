package com.mgvtoptabs.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Created by Mahesh Gubbi on 31-10-2023.
 * Bengaluru.
 */
@Composable
fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setNavigationBarColor(color)
        systemUiController.setSystemBarsColor(color)
        systemUiController.setStatusBarColor(color)
    }
}