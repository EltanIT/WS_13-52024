package com.example.ws_13_52024.feature_app.presentation.Listing

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

class ListingViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsByCategoryUseCase: GetProductsByCategoryUseCase,
): ViewModel() {


    private val _state = mutableStateOf(ListingState())
    val state: State<ListingState> = _state



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

    private fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list = getProductsByCategoryUseCase(_state.value.categories[0].id)
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

    fun setId(s: String) {
        getCategories()
    }
}