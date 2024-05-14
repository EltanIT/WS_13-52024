package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.data.repository.CategoryRepositoryImpl
import com.example.ws_13_52024.feature_app.data.repository.ProductRepositoryImpl
import com.example.ws_13_52024.feature_app.domain.repository.CategoryRepository
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import org.koin.dsl.module

val categoryModule = module {

    single<CategoryRepository> {
        CategoryRepositoryImpl()
    }

    factory<GetAllCategoriesUseCase> {
        GetAllCategoriesUseCase(
            get()
        )
    }
}