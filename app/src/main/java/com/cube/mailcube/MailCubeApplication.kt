package com.cube.mailcube

import android.app.Application
import com.cube.mailcube.di.netWorkModule
import com.cube.mailcube.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MailCubeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startDI()
    }

    private fun startDI() {
        startKoin {
            androidContext(this@MailCubeApplication)
            modules(listOf(viewModelModule, netWorkModule))
        }
    }
}