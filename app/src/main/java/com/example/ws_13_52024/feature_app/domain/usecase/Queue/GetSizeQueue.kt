package com.example.ws_13_52024.feature_app.domain.usecase.Queue

import com.example.ws_13_52024.feature_app.domain.manger.QueueManger

class GetSizeQueue(
    private val manger: QueueManger
) {


    suspend operator fun invoke(): Int{
        val queue = manger.getQueue()
        if (queue != null){
            return queue.size
        }
        return 0
    }
}