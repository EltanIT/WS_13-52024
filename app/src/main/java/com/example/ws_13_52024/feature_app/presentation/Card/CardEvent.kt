package com.example.ws_13_52024.feature_app.presentation.Card

sealed class CardEvent {

    data class Minus(val id: String): CardEvent()
    data class Plus(val id: String): CardEvent()
    data class Delete(val id: String): CardEvent()

}