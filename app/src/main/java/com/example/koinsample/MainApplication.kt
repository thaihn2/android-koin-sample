package com.example.koinsample

import android.app.Application
import com.example.koinsample.di.activityModule
import com.example.koinsample.di.applicationModule
import org.koin.android.ext.android.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule, activityModule))
    }
}
