package com.example.ws_13_52024.feature_app.data.manger

import android.content.Context
import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.presentation.Onboard.OnboardItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import java.util.LinkedList

class QueueMangerImpl(
    val context: Context
): QueueManger {
    private val QueueKey = "Queue"

    val sharedPref = context.getSharedPreferences(QueueKey, Context.MODE_PRIVATE)


    override suspend fun getQueue(): LinkedList<OnboardItem>? {
        val gson = sharedPref.getString(QueueKey, null)
        val type = object: TypeToken<LinkedList<OnboardItem>>(){}.type
        return Gson().fromJson(gson, type)
    }

    override suspend fun saveQueue(queue: LinkedList<OnboardItem>) {
        sharedPref.edit()
            .clear()
            .putString(QueueKey, Gson().toJson(queue))
            .apply()
    }



}