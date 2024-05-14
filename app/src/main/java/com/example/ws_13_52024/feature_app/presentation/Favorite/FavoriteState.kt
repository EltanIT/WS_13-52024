package com.example.ws_13_52024.feature_app.presentation.Favorite

import com.example.ws_13_52024.feature_app.domain.model.ProductData

data class FavoriteState(
    val products: List<ProductData> = emptyList(),

    val exception: String = "",
    val isProductsLoading: Boolean = false,
)
