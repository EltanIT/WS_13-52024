package com.example.ws_13_52024.feature_app.presentation.SignIn

sealed class SignInEvent {

    data class EnteredEmail(val value: String): SignInEvent()
    data class EnteredPassword(val value: String): SignInEvent()

    data object SignIn: SignInEvent()

}