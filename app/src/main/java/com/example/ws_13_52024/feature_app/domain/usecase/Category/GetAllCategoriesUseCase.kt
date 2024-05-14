package com.example.ws_13_52024.feature_app.domain.usecase.Category

import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.CategoryRepository
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository

class GetAllCategoriesUseCase(
   private val repository: CategoryRepository
) {


    suspend operator fun invoke(): List<CategoryData> {
        return repository.getAllCategories()
    }
}