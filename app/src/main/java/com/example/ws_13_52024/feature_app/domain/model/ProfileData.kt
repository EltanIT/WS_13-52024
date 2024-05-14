package com.example.ws_13_52024.feature_app.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ProfileData(
    val id: String,
    val user_id: String,
    val name: String,
    val card: String,
    val email: String,
    val phone: String,
    val created_at: String
)