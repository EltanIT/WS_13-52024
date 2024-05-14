package com.example.ws_13_52024.feature_app.presentation.Home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.model.CategoryData
import com.example.ws_13_52024.feature_app.domain.usecase.Category.GetAllCategoriesUseCase
import com.example.ws_13_52024.feature_app.domain.usecase.Product.GetPopularsProductsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getPopularsProductsUseCase: GetPopularsProductsUseCase,
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getPopularProducts()
        getCategories()
    }




    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.AddInCard -> {

            }
            is HomeEvent.DeleteFromCard -> {

            }
            HomeEvent.OpenDrawer -> {

            }
        }
    }


    private fun getPopularProducts(){
        viewModelScope.launch(Dispatchers.IO) {
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

    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
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
    }
    fun resetException() {
        _state.value = state.value.copy(
            exception = ""
        )
    }
}