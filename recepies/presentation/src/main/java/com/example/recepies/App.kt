package com.example.recepies

import android.app.Application
import com.example.recepies.di.appModule
import com.example.recepies.di.dataModule
import com.example.recepies.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, useCaseModule))
        }
    }
}
