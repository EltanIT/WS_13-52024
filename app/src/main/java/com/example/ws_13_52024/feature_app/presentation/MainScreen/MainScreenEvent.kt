package com.example.ws_13_52024.feature_app.presentation.MainScreen


sealed class MainScreenEvent{

    data class SelectItem(val index: Int): MainScreenEvent()
}