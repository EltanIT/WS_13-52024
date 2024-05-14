package com.example.ws_13_52024.feature_app.presentation.CheckOut

import com.example.ws_13_52024.feature_app.domain.model.ProfileData

data class CheckOutState(
    val profile: ProfileData? = null,
    val sum: Float = 0f,

    val exception: String = "",
    val isLoading: Boolean = false,
    val isComplete: Boolean = false
)
