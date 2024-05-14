package com.example.ws_13_52024.feature_app.presentation.CheckOut

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckOutViewModel(

): ViewModel() {

    private val _state = mutableStateOf(CheckOutState())
    val state: State<CheckOutState> = _state

    init {

    }




    fun onEvent(event: CheckOutEvent){
        when(event){
            CheckOutEvent.Send -> {
                viewModelScope.launch {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                    delay(1000)
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }

            }
        }
    }


    private fun getCard(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Main){

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

    fun setSum(s: String) {
        _state.value = state.value.copy(
            sum = s.toFloat()
        )
    }
}