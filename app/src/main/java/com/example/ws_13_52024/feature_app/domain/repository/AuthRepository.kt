package com.example.ws_13_52024.feature_app.domain.repository

interface AuthRepository {

    suspend fun signIn(mail: String, pass: String)
    suspend fun signUp(mail: String, pass: String, name: String)
}