package com.jcahdos.parcial2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jcahdos.parcial2.navigation.Screens
import com.jcahdos.parcial2.ui.components.ProductCard
import com.jcahdos.parcial2.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(viewModel: ProductViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Productos") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(Screens.Carrito.route)
                    }) {
                        Icon(Icons.Filled.ShoppingCart, contentDescription = "Carrito")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
        ) {
            OutlinedTextField(
                value = viewModel.searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
                label = { Text("Buscar productos") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(viewModel.filteredProducts) { product ->
                    ProductCard(product = product, onClick = {
                        viewModel.selectProduct(product)
                        navController.navigate(Screens.ProductoDetalle.route)
                    })
                }
            }
        }
    }
}
