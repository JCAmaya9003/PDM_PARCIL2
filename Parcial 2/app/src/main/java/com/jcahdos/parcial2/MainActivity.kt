package com.jcahdos.parcial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.jcahdos.parcial2.navigation.AppNavigation
import com.jcahdos.parcial2.ui.theme.Parcial2Theme
import com.jcahdos.parcial2.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial2Theme {
                MainScreenContent()
            }
        }
    }
}

@Composable
fun MainScreenContent() {

    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavigation(navController = navController, viewModel = productViewModel)
    }
}
