package com.example.ws_13_52024.feature_app.data.repository

import com.example.ws_13_52024.feature_app.data.network.SupabaseInit.client
import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.model.ProductData
import com.example.ws_13_52024.feature_app.domain.repository.CardRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest

class CardRepositoryImpl(): CardRepository {

    override suspend fun getMyProducts(): List<ProductCardData> {
        return client.postgrest["card"].select{
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
        }.decodeList<ProductCardData>()
    }

    override suspend fun addItemInCard(productData: ProductData) {
        client.postgrest["card"].insert(mapOf(
            "product_id" to productData.id,
            "name" to productData.name,
            "image" to productData.image,
            "price" to productData.price.toString(),
        ))
    }

    override suspend fun redactItemFromCard(id: String, count: Int) {
        client.postgrest["card"].update(
            {
                set("count", count)
            }
        ){
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
                eq("product_id", id)
            }

        }
    }

    override suspend fun removeItemFromCard(id: String) {
        client.postgrest["card"].delete{
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
                eq("product_id", id)
            }

        }
    }
}