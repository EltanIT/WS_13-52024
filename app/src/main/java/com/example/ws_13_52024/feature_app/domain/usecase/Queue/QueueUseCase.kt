package com.example.ws_13_52024.feature_app.domain.usecase.Queue

data class QueueUseCase(
    val addItemInQueue: AddItemInQueue,
    val clearQueue: ClearQueue,
    val getItemFromQueue: GetItemFromQueue,
    val getSizeQueue: GetSizeQueue,
    val checkIsQueue: CheckIsQueue,
    val createDefaultQueue: CreateDefaultQueue,

) {
}