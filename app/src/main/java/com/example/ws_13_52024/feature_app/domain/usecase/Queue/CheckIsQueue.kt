package com.example.ws_13_52024.feature_app.domain.usecase.Queue

import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem

class CheckIsQueue(
    private val manger: QueueManger
) {


    suspend operator fun invoke(): Boolean{
        val queue = manger.getQueue()
        return queue != null
    }
}