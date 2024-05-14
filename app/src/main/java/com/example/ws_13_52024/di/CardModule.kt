package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.data.repository.CardRepositoryImpl
import com.example.ws_13_52024.feature_app.data.repository.ProductRepositoryImpl
import com.example.ws_13_52024.feature_app.domain.repository.CardRepository
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository
import com.example.ws_13_52024.feature_app.domain.usecase.Card.AddItemInCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.GetMyCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.RemoveItemFromCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.UpdateItemsCountInCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductByIdUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductsByCategoryUseCase
import org.koin.dsl.module

val cardModule = module {

    single<CardRepository> {
        CardRepositoryImpl()
    }

    factory<GetMyCardUseCase> {
        GetMyCardUseCase(
            get()
        )
    }

    factory<AddItemInCardUseCase> {
        AddItemInCardUseCase(
            get()
        )
    }

    factory<RemoveItemFromCardUseCase> {
        RemoveItemFromCardUseCase(
            get()
        )
    }

    factory<UpdateItemsCountInCardUseCase> {
        UpdateItemsCountInCardUseCase(
            get()
        )
    }
}