package com.example.ws_13_52024.feature_app.presentation.Listing

import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.model.ProductData

data class ListingState(
    val categories: List<CategoryData> = emptyList(),
    val products: List<ProductData> = emptyList(),

    val exception: String = "",


    val isCategoryLoading: Boolean = false,
    val isProductsLoading: Boolean = false,
)
