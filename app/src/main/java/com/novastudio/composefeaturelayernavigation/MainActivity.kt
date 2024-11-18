package com.novastudio.composefeaturelayernavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.novastudio.composefeaturelayernavigation.core.navigation.NavigationWrapper
import com.novastudio.composefeaturelayernavigation.core.ui.theme.ComposeFeatureLayerNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFeatureLayerNavigationTheme {
                NavigationWrapper()
            }
        }
    }
}