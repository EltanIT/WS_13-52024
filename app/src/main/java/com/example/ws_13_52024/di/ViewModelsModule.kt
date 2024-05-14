package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.presentation.Card.CardViewModel
import com.example.ws_13_52024.feature_app.presentation.CheckOut.CheckOutViewModel
import com.example.ws_13_52024.feature_app.presentation.Favorite.FavoriteViewModel
import com.example.ws_13_52024.feature_app.presentation.ForgotPass.ForgotPassViewModel
import com.example.ws_13_52024.feature_app.presentation.Home.HomeViewModel
import com.example.ws_13_52024.feature_app.presentation.Listing.ListingViewModel
import com.example.ws_13_52024.feature_app.presentation.MainActivityViewModel
import com.example.ws_13_52024.feature_app.presentation.MainScreen.MainScreenViewModel
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardViewModel
import com.example.ws_13_52024.feature_app.presentation.ProductDetails.ProductDetailsViewModel
import com.example.ws_13_52024.feature_app.presentation.SignIn.SignInViewModel
import com.example.ws_13_52024.feature_app.presentation.SignUp.SignUpViewModel
import com.example.ws_13_52024.feature_app.presentation.VerificationPass.VerificationPassViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel<OnboardViewModel> {
        OnboardViewModel(get())
    }

    viewModel<MainActivityViewModel> {
        MainActivityViewModel(get())
    }

    viewModel<SignInViewModel>{
        SignInViewModel(get())
    }

    viewModel<SignUpViewModel>{
        SignUpViewModel(get())
    }

    viewModel<ForgotPassViewModel>{
        ForgotPassViewModel()
    }

    viewModel<VerificationPassViewModel>{
        VerificationPassViewModel()
    }

    viewModel<MainScreenViewModel>{
        MainScreenViewModel()
    }

    viewModel<HomeViewModel>{
        HomeViewModel(
            get(),
            get(),
            get(),
            get(),
            get(),
        )
    }

    viewModel<ProductDetailsViewModel>{
        ProductDetailsViewModel(get())
    }

    viewModel<ListingViewModel>{
        ListingViewModel(get(), get())
    }

    viewModel<CardViewModel>{
        CardViewModel(get(), get(), get())
    }

    viewModel<FavoriteViewModel>{
        FavoriteViewModel(get())
    }

    viewModel<CheckOutViewModel>{
        CheckOutViewModel()
    }
}