package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.data.repository.AuthRepositoryImpl
import com.example.ws_13_52024.feature_app.domain.repository.AuthRepository
import com.example.ws_13_52024.feature_app.domain.usecase.Auth.SignInUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Auth.SignUpUseCase
import org.koin.dsl.module

val authModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }

    factory<SignInUseCase> {
        SignInUseCase(get())
    }

    factory<SignUpUseCase> {
        SignUpUseCase(get())
    }
}