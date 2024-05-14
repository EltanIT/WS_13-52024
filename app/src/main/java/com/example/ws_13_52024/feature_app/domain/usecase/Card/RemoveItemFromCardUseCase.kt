package com.example.ws_13_52024.feature_app.domain.usecase.Card

import com.example.ws_13_52024.feature_app.domain.repository.CardRepository

class RemoveItemFromCardUseCase(
   private val repository: CardRepository
) {


    suspend operator fun invoke(id: String) {
        repository.removeItemFromCard(id)
    }
}