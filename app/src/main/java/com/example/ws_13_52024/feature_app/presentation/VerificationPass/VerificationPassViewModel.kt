package com.example.ws_13_52024.feature_app.presentation.VerificationPass

import android.os.CountDownTimer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.utils.generatePasswordFromPhrase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class VerificationPassViewModel(

): ViewModel() {

    private val _state = mutableStateOf(VerificationPassState())
    val state: State<VerificationPassState> = _state


    init {
        timer()
    }
    fun onEvent(event: VerificationPassEvent){
        when(event){
            is VerificationPassEvent.EnteredCode -> {
                if (event.value.length < 6){
                    _state.value = state.value.copy(
                        code = event.value
                    )
                }else{
                    _state.value = state.value.copy(
                        isLoading = true,
                        code = event.value
                    )
                    viewModelScope.launch {
                        delay(1000)
                        _state.value = state.value.copy(
                            isLoading = false,
                            isComplete = true,
                            code = ""
                        )
                    }
                }

            }

            VerificationPassEvent.RestartTimer -> {
                timer()
            }

            is VerificationPassEvent.EnteredPhrase -> {
                _state.value = state.value.copy(
                    phrase = event.value
                )
            }
            VerificationPassEvent.GeneratePass -> {
                _state.value = state.value.copy(
                    password = generatePasswordFromPhrase(state.value.phrase)
                )
            }
        }
    }


    private fun timer(){
        val timer = object : CountDownTimer(30000, 1000){
            override fun onTick(value: Long) {
                val text = if (value<10000) "0${value/1000}" else "${value/1000}"
                _state.value = state.value.copy(
                    timer = "00:$text"
                )
            }

            override fun onFinish() {
                _state.value = state.value.copy(
                    timer = "00:00"
                )
            }

        }
        timer.start()
    }

    fun resetComplete() {
        _state.value = state.value.copy(
            isComplete = false
        )
    }
}