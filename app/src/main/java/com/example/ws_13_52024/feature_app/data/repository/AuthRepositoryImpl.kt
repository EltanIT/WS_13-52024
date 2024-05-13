package com.example.ws_13_52024.feature_app.data.repository

import com.example.ws_13_52024.feature_app.data.network.SupabaseInit.client
import com.example.ws_13_52024.feature_app.domain.repository.AuthRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.postgrest

class AuthRepositoryImpl(): AuthRepository {
    override suspend fun signIn(mail: String, pass: String) {
        client.auth.signInWith(Email){
            email = mail
            password = pass
        }
    }

    override suspend fun signUp(mail: String, pass: String, name: String) {
        client.auth.signUpWith(Email){
            email = mail
            password = pass
        }

        client.postgrest["profile"].insert(mapOf("name" to name)){
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
        }
    }
}