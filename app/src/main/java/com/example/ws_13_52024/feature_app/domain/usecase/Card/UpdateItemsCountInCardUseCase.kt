package com.example.ws_13_52024.feature_app.domain.usecase.Card

import com.example.ws_13_52024.feature_app.domain.repository.CardRepository

class UpdateItemsCountInCardUseCase(
   private val repository: CardRepository
) {


    suspend operator fun invoke(id: String, count: Int) {
        repository.redactItemFromCard(id, count)
    }
}