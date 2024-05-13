package com.example.ws_13_52024.feature_app.domain.usecase.Queue

import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem

class GetItemFromQueue(
    private val manger: QueueManger
) {


    suspend operator fun invoke(): OnboardItem?{
        val queue = manger.getQueue()
        if (queue != null){
            if (queue.size>0){
                val item = queue.pop()
                manger.saveQueue(queue)
                return item
            }
        }
        return null
    }
}