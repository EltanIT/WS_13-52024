package com.example.ws_13_52024.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.usecase.Card.AddItemInCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.GetMyCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Card.RemoveItemFromCardUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPopularsProductsUseCase: GetPopularsProductsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,

    private val getMyCardUseCase: GetMyCardUseCase,

    private val addItemInCardUseCase: AddItemInCardUseCase,
    private val removeItemFromCardUseCase: RemoveItemFromCardUseCase,
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            launch { getPopularProducts() }
            launch { getCard() }
            getCategories()
        }

    }

    private suspend fun getCard() {
        try {
            val list = getMyCardUseCase()
            withContext(Dispatchers.Main){
                _state.value = state.value.copy(
                    myCard = list
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


    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.AddInCard -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        addItemInCardUseCase(state.value.populars.find { it.id.equals(event.id) }!!)
                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
            is HomeEvent.DeleteFromCard -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        removeItemFromCardUseCase(event.id)
                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            exception = e.message.toString()
                        )
                    }
                }
            }
            HomeEvent.OpenDrawer -> {

            }
        }
    }


    private suspend fun getPopularProducts(){
        try {
            val list = getPopularsProductsUseCase()
            withContext(Dispatchers.Main){
                _state.value = state.value.copy(
                    populars = list
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

    private suspend fun getCategories() {
        try {
            val list = getAllCategoriesUseCase()

            val arrayList = ArrayList<CategoryData>()
            arrayList.add(CategoryData("", "Все", ""))
            arrayList.addAll(list)

            withContext(Dispatchers.Main){
                _state.value = state.value.copy(
                    categories = arrayList.toList()
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
    fun resetException() {
        _state.value = state.value.copy(
            exception = ""
        )
    }
}