package com.example.ws_13_52024.feature_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_13_52024.R
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.QueueUseCase
import com.example.ws_13_52024.feature_app.presentation.NavGraph.Route
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.LinkedList

class MainActivityViewModel(
    private val useCase: QueueUseCase
): ViewModel() {
    
    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination = _startDestination.asStateFlow()



    fun checkStartDestination(){
        viewModelScope.launch(Dispatchers.IO) {
            val queue = useCase.checkIsQueue()
            if (queue){
                if (useCase.getSizeQueue() > 0){
                    _startDestination.value = Route.Onboard.route
                }else{
                    _startDestination.value = Route.SignIn.route
                }
            }else{
                val list = listOf(
                    OnboardItem(
                        R.drawable.ic_onboard1,
                        "",
                        ""
                    ),
                    OnboardItem(
                        R.drawable.ic_onboard2,
                        "Начнем путешествие",
                        "Умная, великолепная и модная коллекция Изучите сейчас"
                    ),
                    OnboardItem(
                        R.drawable.ic_onboard3,
                        "У вас есть сила, чтобы",
                        "В вашей комнате много красивых и привлекательных растений"
                    ),
                )
                useCase.createDefaultQueue(LinkedList(list))
                _startDestination.value = Route.Onboard.route
            }
        }
    }
}