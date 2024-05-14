package com.example.ws_13_52024.feature_app.presentation.CheckOut

sealed class CheckOutEvent {
    data object Send: CheckOutEvent()

}