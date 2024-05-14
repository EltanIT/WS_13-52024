package com.example.ws_13_52024.feature_app.data.repository

import com.example.ws_13_52024.feature_app.data.network.SupabaseInit.client
import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.AuthRepository
import com.example.ws_13_52024.feature_app.domain.repository.ProductRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

class ProductRepositoryImpl(): ProductRepository {

    override suspend fun getAllProducts(): List<ProductData> {
        return client.postgrest["product"].select().decodeList<ProductData>()
    }

    override suspend fun getPopularProducts(): List<ProductData>  {
       return client.postgrest["product"].select {
            filter {
                eq("category", "0a6ead76-e000-4b2a-a628-32c5a8d06c29")
            }
        }.decodeList<ProductData>()
    }

    override suspend fun getProductsByCategory(category: String): List<ProductData> {
        return client.postgrest["product"].select {
            filter {
                eq("category", category)
            }
        }.decodeList<ProductData>()
    }

    override suspend fun getProductById(id: String): ProductData {
        return client.postgrest["product"].select {
            filter {
                eq("id", id)
            }
        }.decodeList<ProductData>()[0]
    }

    override suspend fun getProductBySearch(search: String): List<ProductData>  {
        return client.postgrest["product"].select {
            filter {
                eq("name", search)
            }
        }.decodeList<ProductData>()
    }
}