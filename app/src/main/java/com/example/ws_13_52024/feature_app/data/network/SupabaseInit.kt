package com.example.ws_13_52024.feature_app.data.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SupabaseInit {

    val client = createSupabaseClient(
        supabaseUrl = "https://lsottvdiyggclkjaotoe.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imxzb3R0dmRpeWdnY2xramFvdG9lIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTU1OTkzOTksImV4cCI6MjAzMTE3NTM5OX0.W4xvYB067L5S8ZgHsCT2GJZkaPSpbpaWPU18oko-dv0"
    ){
        install(Postgrest)
        install(Auth)
        install(Storage)
    }
}