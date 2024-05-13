package com.example.ws_13_52024.feature_app.presentation.SignUp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.usecase.Auth.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val useCase: SignUpUseCase
): ViewModel() {

    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent){
        when(event){
            SignUpEvent.CheckPolice -> {
                _state.value = state.value.copy(
                    policeIsCheck = !state.value.policeIsCheck
                )
            }
            is SignUpEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is SignUpEvent.EnteredName -> {
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is SignUpEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            SignUpEvent.SignUp -> {
                viewModelScope.launch {
                    try {
                        if (state.value.policeIsCheck){
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                            useCase(state.value.email, state.value.password, state.value.name)

                            _state.value = state.value.copy(
                                isComplete = true,
                                isLoading = false
                            )
                        }else{
                            _state.value = state.value.copy(
                                exception = "Дайте согласие на обработку персональных данных"
                            )
                        }

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