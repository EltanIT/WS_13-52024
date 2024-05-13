package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.presentation.MainActivityViewModel
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel<OnboardViewModel> {
        OnboardViewModel(get())
    }

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(get())
    }
}