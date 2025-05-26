package com.jcahdos.parcial2.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.jcahdos.parcial2.data.model.Product

class ProductViewModel : ViewModel() {

    private val _products = listOf(
        Product(1, "Laptop Lenovo", "Electronica", 599.99, "Laptop de alto rendimiento, porfi comprela", "https://images.pexels.com/photos/1359327/pexels-photo-1359327.jpeg"),
        Product(2, "Auriculares Sony", "Audio, Electronica", 9.99, "Auriculares con cancelación de ruido, para no escuchar sus mentiras", "https://images.pexels.com/photos/3541365/pexels-photo-3541365.jpeg"),
        Product(3, "Manzana", "Fruta", 0.75, "Una manzana bien saludable", "https://images.pexels.com/photos/102104/pexels-photo-102104.jpeg"),
        Product(8, "Helicoptero", "Aeronave", 100000.01, "Ultima generacion de helicopter M27", "https://images.pexels.com/photos/914381/pexels-photo-914381.jpeg"),
    )

    var searchQuery by mutableStateOf("")
        private set

    val filteredProducts: List<Product>
        get() = _products.filter {
            it.name.contains(searchQuery, ignoreCase = true) ||
                    it.category.contains(searchQuery, ignoreCase = true)
        }

    var selectedProduct by mutableStateOf<Product?>(null)
        private set

    var cartItems by mutableStateOf(listOf<Product>())
        private set

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun addToCart(product: Product) {
        if (!cartItems.contains(product)) {
            product.addedToCart = true
            cartItems = cartItems + product
        }
    }
}

