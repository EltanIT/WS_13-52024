package com.example.ws_13_52024.feature_app.presentation.SignUp

data class SignUpState(
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val exception: String = "",
    val isLoading: Boolean = false,
    val isComplete: Boolean = false,

    val policeIsCheck: Boolean = false
)