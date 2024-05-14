package com.example.ws_13_52024.feature_app.presentation.ProductDetails

import com.example.ws_13_52024.feature_app.domain.model.ProductData

data class ProductDetailsState(
    val product: ProductData? = null,
    val exception: String = "",

    val cardIsEmpty: Boolean = true,
    val isLoading: Boolean = false,
)
