package com.example.ws_13_52024.feature_app.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class CategoryData(
    val id: String,
    val name: String,
    val created_at: String
)