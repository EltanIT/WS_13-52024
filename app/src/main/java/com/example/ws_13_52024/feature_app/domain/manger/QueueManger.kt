package com.example.ws_13_52024.feature_app.domain.manger

import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import java.util.LinkedList

interface QueueManger {


    suspend fun getQueue(): LinkedList<OnboardItem>?

    suspend fun saveQueue(queue: LinkedList<OnboardItem>)
}