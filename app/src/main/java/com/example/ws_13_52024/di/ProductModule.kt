package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.data.repository.ProductRepositoryImpl
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductByIdUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductsByCategoryUseCase
import org.koin.dsl.module

val productModule = module {

    single<ProductRepository> {
        ProductRepositoryImpl()
    }

    factory<GetPopularsProductsUseCase> {
        GetPopularsProductsUseCase(
            get()
        )
    }

    factory<GetProductByIdUseCase> {
        GetProductByIdUseCase(
            get()
        )
    }

    factory<GetProductsByCategoryUseCase> {
        GetProductsByCategoryUseCase(
            get()
        )
    }
}