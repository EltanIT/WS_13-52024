package com.example.ws_13_52024.feature_app.presentation.VerificationPass

data class VerificationPassState(
    val code: String = "",
    val phrase: String = "",
    val password: String = "",
    val timer: String = "",

    val isLoading: Boolean = false,
    val isComplete: Boolean = false,
)