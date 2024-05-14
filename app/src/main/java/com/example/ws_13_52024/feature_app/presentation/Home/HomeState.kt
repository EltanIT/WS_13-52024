package com.example.ws_13_52024.feature_app.presentation.Home

import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.model.ProductData

data class HomeState(
    val categories: List<CategoryData> = emptyList(),
    val populars: List<ProductData> = emptyList(),
    val myCard: List<ProductCardData> = emptyList(),

    val actia: String = "",
    val exception: String = "",

    val cardIsEmpty: Boolean = true,
    val isCategoryLoading: Boolean = false,
    val isPopularsLoading: Boolean = false,
    val isActiaLoading: Boolean = false
)
