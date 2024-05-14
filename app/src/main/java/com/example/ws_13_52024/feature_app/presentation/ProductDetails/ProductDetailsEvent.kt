package com.example.ws_13_52024.feature_app.presentation.ProductDetails

sealed class ProductDetailsEvent {

    data class AddInCard(val id: String): ProductDetailsEvent()
    data class DeleteFromCard(val id: String): ProductDetailsEvent()
    data class AddInFavorite(val id: String): ProductDetailsEvent()
    data class DeleteFromFavorite(val id: String): ProductDetailsEvent()

}