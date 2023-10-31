package com.mgvtoptabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.mgvtoptabs.presentation.MainScreen
import com.mgvtoptabs.ui.theme.MgvTopTabsTheme
import com.mgvtoptabs.ui.theme.Purple40
import com.mgvtoptabs.utils.SetStatusBarColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MgvTopTabsTheme {
//                 here we can modified the Bottom status color
//                SetStatusBarColor(color = MaterialTheme.colorScheme.primary)
                SetStatusBarColor(color = Purple40)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContent {
                        this.window.statusBarColor = ContextCompat.getColor(this,R.color.purple_200)
                        MainScreen()
                    }
                }
            }
        }
    }
}