package com.example.ws_13_52024.feature_app.presentation.Onboard

data class OnboardState(
    val page: OnboardItem = OnboardItem(0, "", ""),
    val size: Int = 0,
    val isComplete: Boolean = false
)