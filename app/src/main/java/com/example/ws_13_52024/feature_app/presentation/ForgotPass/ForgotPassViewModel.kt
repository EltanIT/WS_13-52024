package com.example.ws_13_52024.feature_app.presentation.ForgotPass

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForgotPassViewModel(

): ViewModel() {

    private val _state = mutableStateOf(ForgotPassState())
    val state: State<ForgotPassState> = _state

    fun onEvent(event: ForgotPassEvent){
        when(event){
            is ForgotPassEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }

            ForgotPassEvent.Send -> {
                viewModelScope.launch(Dispatchers.IO) {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                    delay(1000)
                    _state.value = state.value.copy(
                        isLoading = false,
                        isComplete = true
                    )
                }
            }
        }
    }

    fun resetComplete() {
        _state.value = state.value.copy(
            isComplete = false
        )
    }
}