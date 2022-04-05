package com.example.professionaldevelopment.application

import android.app.Application
import com.example.professionaldevelopment.di.application
import com.example.professionaldevelopment.di.mainScreen
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}