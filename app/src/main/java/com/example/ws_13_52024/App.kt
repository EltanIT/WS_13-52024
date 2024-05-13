package com.example.ws_13_52024

import android.app.Application
import com.example.ws_13_52024.di.authModule
import com.example.ws_13_52024.di.queueModule
import com.example.ws_13_52024.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(listOf(queueModule, viewModelsModule, authModule))
        }
    }
}