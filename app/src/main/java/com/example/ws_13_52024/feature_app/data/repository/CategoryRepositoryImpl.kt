package com.example.ws_13_52024.feature_app.data.repository

import com.example.ws_13_52024.feature_app.data.network.SupabaseInit.client
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.repository.CategoryRepository
import io.github.jan.supabase.postgrest.postgrest

class CategoryRepositoryImpl(): CategoryRepository {
    override suspend fun getAllCategories(): List<CategoryData> {
        return client.postgrest["category"].select{}.decodeList<CategoryData>()
    }
}