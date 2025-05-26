package com.jcahdos.parcial2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jcahdos.parcial2.ui.screens.CartScreen
import com.jcahdos.parcial2.ui.screens.ProductDetailScreen
import com.jcahdos.parcial2.ui.screens.ProductListScreen
import com.jcahdos.parcial2.viewmodel.ProductViewModel

sealed class Screens(val route: String) {
    object ProductoLista : Screens("ProductoLista")
    object ProductoDetalle : Screens("ProductoDetalle")
    object Carrito : Screens("Carrito")
}

@Composable
fun AppNavigation(navController: NavHostController, viewModel: ProductViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.ProductoLista.route
    ) {
        composable(route = Screens.ProductoLista.route) {
            ProductListScreen(viewModel, navController)
        }

        composable(route = Screens.ProductoDetalle.route) {
            ProductDetailScreen(viewModel, navController)
        }

        composable(route = Screens.Carrito.route) {
            CartScreen(viewModel, navController)
        }
    }
}
