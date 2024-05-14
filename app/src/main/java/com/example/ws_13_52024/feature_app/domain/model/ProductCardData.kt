package com.example.ws_13_52024.feature_app.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ProductCardData(
    val id: String,
    val product_id: String,
    val name: String,
    val price: Float,
    val image: String,
    val created_at: String,

    val count: Int = 1
)