package com.example.ws_13_52024.feature_app.presentation.SignIn

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.usecase.Auth.SignInUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignInViewModel(
    private val useCase: SignInUseCase
): ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    fun onEvent(event: SignInEvent){
        when(event){
            is SignInEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is SignInEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            SignInEvent.SignIn -> {
                viewModelScope.launch(Dispatchers.IO) {
                    try {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                        useCase(state.value.email, state.value.password)

                        _state.value = state.value.copy(
                            isComplete = true,
                            isLoading = false
                        )
                    }catch (e: Exception){
                        _state.value = state.value.copy(
                            isComplete = false,
                            isLoading = false,
                            exception = e.message.toString()
                        )
                    }

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