package com.example.ws_13_52024.feature_app.domain.usecase.Card

import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.CardRepository

class AddItemInCardUseCase(
   private val repository: CardRepository
) {


    suspend operator fun invoke(item: ProductData) {
        repository.addItemInCard(item)
    }
}