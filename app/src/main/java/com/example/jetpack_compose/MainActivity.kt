package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.jetpack_compose.navhost.Navigation_page
import com.example.jetpack_compose.ui.theme.Jetpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_composeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(
) {
Navigation_page()
}