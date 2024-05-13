package com.example.ws_13_52024.feature_app.presentation.ForgotPass

data class ForgotPassState(
    val email: String = "",
    val isLoading: Boolean = false,
    val isComplete: Boolean = false
)