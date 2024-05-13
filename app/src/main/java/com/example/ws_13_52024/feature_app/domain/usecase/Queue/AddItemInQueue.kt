package com.example.ws_13_52024.feature_app.domain.usecase.Queue

import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem

class AddItemInQueue(
    private val manger: QueueManger
) {


    suspend operator fun invoke(item: OnboardItem){
        val queue = manger.getQueue()
        if (queue != null){
            queue.add(item)
            manger.saveQueue(queue)
        }
    }
}