package com.example.ws_13_52024.feature_app.presentation.ForgotPass

sealed class ForgotPassEvent {

    data class EnteredEmail(val value: String): ForgotPassEvent()
    data object Send: ForgotPassEvent()

}