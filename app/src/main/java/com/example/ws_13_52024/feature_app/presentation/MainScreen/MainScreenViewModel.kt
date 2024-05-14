package com.example.ws_13_52024.feature_app.presentation.MainScreen

import androidx.lifecycle.ViewModel
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainScreenViewModel(

): ViewModel() {

    private val _selectedItem = MutableStateFlow(0)
    val selectedItem = _selectedItem.asStateFlow()


    val navigationList = listOf(
        NavigateItem(
            R.drawable.ic_home,
            Route.Home.route
        ),
        NavigateItem(
            R.drawable.ic_favorites,
            Route.Favorite.route
        ),
        NavigateItem(
            R.drawable.ic_notification,
            Route.Home.route
        ),
        NavigateItem(
            R.drawable.ic_profile,
            Route.Home.route
        ),



    )

    fun onEvent(event: MainScreenEvent){
        when(event){
            is MainScreenEvent.SelectItem -> {
                _selectedItem.value = event.index
            }
        }
    }
}