package com.example.ws_13_52024.feature_app.presentation.ProductDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetProductByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase
): ViewModel() {

    private val _state = mutableStateOf(ProductDetailsState())
    val state: State<ProductDetailsState> = _state


    private var productId = ""

    fun onEvent(event: ProductDetailsEvent){
        when(event){
            is ProductDetailsEvent.AddInCard -> {

            }
            is ProductDetailsEvent.AddInFavorite -> {

            }
            is ProductDetailsEvent.DeleteFromCard -> {

            }
            is ProductDetailsEvent.DeleteFromFavorite -> {

            }
        }
    }

    fun setId(id: String) {
        productId = id
        getProduct()
    }

    private fun getProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val product = getProductByIdUseCase(productId)
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        product = product
                    )
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        exception = e.message.toString()
                    )
                }
            }
        }
    }

    fun resetException() {
        _state.value = state.value.copy(
            exception = ""
        )
    }
}