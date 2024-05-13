package com.example.ws_13_52024.feature_app.presentation.VerificationPass

sealed class VerificationPassEvent {

    data class EnteredCode(val value: String): VerificationPassEvent()
    data class EnteredPhrase(val value: String): VerificationPassEvent()
    data object RestartTimer: VerificationPassEvent()
    data object GeneratePass: VerificationPassEvent()
}