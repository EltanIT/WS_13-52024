package com.example.ws_13_52024.feature_app.presentation.SignUp

sealed class SignUpEvent {

    data class EnteredEmail(val value: String): SignUpEvent()
    data class EnteredName(val value: String): SignUpEvent()
    data object CheckPolice: SignUpEvent()
    data class EnteredPassword(val value: String): SignUpEvent()

    data object SignUp: SignUpEvent()

}