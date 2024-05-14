package com.example.ws_13_52024.feature_app.presentation.Home

sealed class HomeEvent {

    data class AddInCard(val id: String): HomeEvent()
    data class DeleteFromCard(val id: String): HomeEvent()

    data object OpenDrawer: HomeEvent()

}