package com.example.ws_13_52024.feature_app.domain.usecase.Product

import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository

class GetPopularsProductsUseCase(
   private val repository: ProductRepository
) {


    suspend operator fun invoke(): List<ProductData> {
        return repository.getPopularProducts()
    }
}