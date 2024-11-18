package com.novastudio.composefeaturelayernavigation

import android.app.Application
import com.novastudio.composefeaturelayernavigation.core.di.appModule
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}