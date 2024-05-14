package com.example.ws_13_52024.feature_app.presentation.Favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductsByCategoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(
    private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase,
): ViewModel() {


    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = getProductsByCategoryUseCase("")
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        products = list
                    )
                }
                getProducts()
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        exception = e.message.toString()
                    )
                }
            }
        }
    }
}