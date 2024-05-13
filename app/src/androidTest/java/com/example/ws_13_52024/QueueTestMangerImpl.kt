package com.example.ws_13_52024

import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import java.util.LinkedList

class QueueTestMangerImpl: QueueManger {

    private var queue = LinkedList<OnboardItem>()

    override suspend fun getQueue(): LinkedList<OnboardItem>? {
        return queue
    }

    override suspend fun saveQueue(queue: LinkedList<OnboardItem>) {
        this.queue = queue
    }
}