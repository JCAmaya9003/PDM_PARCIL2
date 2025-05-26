package com.jcahdos.parcial2.data.model

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    var addedToCart: Boolean = false
)
