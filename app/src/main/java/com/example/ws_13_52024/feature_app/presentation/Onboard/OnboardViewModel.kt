package com.example.ws_13_52024.feature_app.presentation.Onboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.QueueUseCase
import kotlinx.coroutines.launch

class OnboardViewModel(
    private val useCase: QueueUseCase
): ViewModel() {

    private val _state = mutableStateOf(OnboardState())
    val state: State<OnboardState> = _state

    init {
        getQueueSize()
    }

    private fun getQueueSize() {
        viewModelScope.launch {
            val size = useCase.getSizeQueue()
            _state.value = state.value.copy(
                size = size
            )
        }
    }

    fun onEvent(event: OnboardEvent){
        when(event){
            OnboardEvent.NextPage -> {
                viewModelScope.launch {
                   val item = useCase.getItemFromQueue()
                    if (item != null){
                        _state.value = state.value.copy(
                            page = item
                        )
                    }else{
                        _state.value = state.value.copy(
                            isComplete = true
                        )
                    }

                }

            }
        }
    }
}