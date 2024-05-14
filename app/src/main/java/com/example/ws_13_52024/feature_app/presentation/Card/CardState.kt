package com.example.ws_13_52024.feature_app.presentation.Card

import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.model.ProductData

data class CardState(
    val card: List<ProductCardData> = emptyList(),
    val sum: Float = 0f,

    val exception: String = "",
    val isLoading: Boolean = false
)
