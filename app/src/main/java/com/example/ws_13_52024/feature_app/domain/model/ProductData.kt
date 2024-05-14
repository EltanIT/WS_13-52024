package com.example.ws_13_52024.feature_app.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ProductData(
    val id: String,
    val name: String,
    val category: String,
    val shop: String,
    val price: String,
    val image: String,
    val description: String,
    val model: String? = null,
    val created_at: String
)