package com.example.ws_13_52024.feature_app.presentation.Card

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.model.ProductCardData
import com.example.ws_13_52024.feature_app.domain.usecase.Card.GetMyCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.RemoveItemFromCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.UpdateItemsCountInCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardViewModel(
    private val getMyCardUseCase: GetMyCardUseCase,
    private val updateItemsCountInCardUseCase: UpdateItemsCountInCardUseCase,
    private val removeItemFromCardUseCase: RemoveItemFromCardUseCase
): ViewModel() {

    private val _state = mutableStateOf(CardState())
    val state: State<CardState> = _state

    init {
        getCard()
    }


    fun onEvent(event: CardEvent){
        when(event){
            is CardEvent.Delete -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        removeItemFromCardUseCase(event.id)

                        val item = state.value.card.find { it.id.equals(event.id) }
                        item?.let {
                            val list = ArrayList<ProductCardData>()
                            list.addAll(state.value.card)
                            list.remove(item)

                            _state.value = state.value.copy(
                                card = list,
                                sum = state.value.sum - (item.count * item.price)
                            )
                        }


                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
            is CardEvent.Minus -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val item = state.value.card.find { it.id.equals(event.id) }

                        if (item?.count!=1){
                            updateItemsCountInCardUseCase(event.id, item!!.count-1)

                            val list = ArrayList<ProductCardData>()
                            list.addAll(state.value.card)
                            list[list.indexOf(item)] = item.copy(
                                count = item.count-1
                            )

                            _state.value = state.value.copy(
                                card = list,
                                sum = state.value.sum - item.price
                            )
                        }
                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
            is CardEvent.Plus -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        val item = state.value.card.find { it.id.equals(event.id) }

                        updateItemsCountInCardUseCase(event.id, item!!.count+1)

                        val list = ArrayList<ProductCardData>()
                        list.addAll(state.value.card)
                        list[list.indexOf(item)] = item.copy(
                            count = item.count+1
                        )

                        _state.value = state.value.copy(
                            card = list,
                            sum = state.value.sum + item.price
                        )
                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
        }
    }


    private fun getCard(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = getMyCardUseCase()
                withContext(Dispatchers.Main){
                    _state.value = state.value.copy(
                        card = list
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