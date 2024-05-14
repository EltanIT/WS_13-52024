package com.example.ws_13_52024.feature_app.domain.repository

import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.model.ProductData

interface CardRepository {

    suspend fun getMyProducts(): List<ProductCardData>

    suspend fun addItemInCard(productData: ProductData)
    suspend fun redactItemFromCard(id: String, count: Int)

    suspend fun removeItemFromCard(id: String)
}