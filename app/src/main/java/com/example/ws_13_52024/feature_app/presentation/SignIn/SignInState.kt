package com.example.ws_13_52024.feature_app.presentation.SignIn

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isComplete: Boolean = false
)