package com.example.ws_13_52024.di

import com.example.ws_13_52024.feature_app.data.manger.QueueMangerImpl
import com.example.ws_13_52024.feature_app.domain.manger.QueueManger
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.AddItemInQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.CheckIsQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.ClearQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.CreateDefaultQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.GetItemFromQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.GetSizeQueue
import com.example.ws_13_52024.feature_app.domain.usecase.Queue.QueueUseCase
import org.koin.dsl.module

val queueModule = module {

    single<QueueManger> {
        QueueMangerImpl(get())
    }

    factory<QueueUseCase> {
        QueueUseCase(
            AddItemInQueue(get()),
            ClearQueue(get()),
            GetItemFromQueue(get()),
            GetSizeQueue(get()),
            CheckIsQueue(get()),
            CreateDefaultQueue(get())
        )
    }
}