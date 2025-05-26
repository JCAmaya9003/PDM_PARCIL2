package com.jcahdos.parcial2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jcahdos.parcial2.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(viewModel: ProductViewModel, navController: NavController) {
    val product = viewModel.selectedProduct ?: return

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detalle de Producto") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Categoría: ${product.category}")
            Text(text = "Precio: $${product.price}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.description)

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.addToCart(product)
                    navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Agregar al carrito")
            }
        }
    }
}
