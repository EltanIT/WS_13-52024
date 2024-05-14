package com.example.ws_13_52024.feature_app.domain.usecase.Card

import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.repository.CardRepository

class GetMyCardUseCase(
   private val repository: CardRepository
) {


    suspend operator fun invoke(): List<ProductCardData> {
        return repository.getMyProducts()
    }
}