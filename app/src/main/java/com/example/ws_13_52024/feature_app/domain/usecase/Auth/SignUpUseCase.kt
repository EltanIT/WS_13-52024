package com.example.ws_13_52024.feature_app.domain.usecase.Auth

import com.example.ws_13_52024.feature_app.domain.repository.AuthRepository

class SignUpUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(mail: String, pass: String, name: String){
        repository.signUp(mail, pass, name)
    }
}