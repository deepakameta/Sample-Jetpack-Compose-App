package com.robustdev.samplecomposeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.robustdev.samplecomposeapp.navigation.NavigationGraph
import com.robustdev.samplecomposeapp.ui.theme.SampleComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleComposeAppTheme {
                NavigationGraph()
            }
        }
    }
}