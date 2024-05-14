package com.example.ws_13_52024.feature_app.domain.repository

import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.model.ProductData

interface CategoryRepository {

    suspend fun getAllCategories(): List<CategoryData>
}