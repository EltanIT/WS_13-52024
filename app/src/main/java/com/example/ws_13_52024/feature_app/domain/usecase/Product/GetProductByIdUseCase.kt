package com.example.ws_13_52024.feature_app.domain.usecase.Product

import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository

class GetProductByIdUseCase(
   private val repository: ProductRepository
) {

    suspend operator fun invoke(id: String): ProductData {
        return repository.getProductById(id)
    }
}