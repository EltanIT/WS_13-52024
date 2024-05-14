package com.example.ws_13_52024.feature_app.domain.repository

import com.example.ws_13_52024.feature_app.domain.model.ProductData

interface ProductRepository {

    suspend fun getAllProducts(): List<ProductData>
    suspend fun getPopularProducts(): List<ProductData>
    suspend fun getProductsByCategory(category: String): List<ProductData>
    suspend fun getProductById(id: String): ProductData
    suspend fun getProductBySearch(search: String): List<ProductData>
}