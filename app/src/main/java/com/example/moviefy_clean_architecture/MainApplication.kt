package com.example.moviefy_clean_architecture

import android.app.Application
import com.example.moviefy_clean_architecture.common.AppInfo
import com.example.moviefy_clean_architecture.common.di.CommonModule
import com.example.moviefy_clean_architecture.network.infra.module.di.NetworkInfraModule
import com.example.moviefy_clean_architecture.network.service.module.di.NetworkServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    private val appInfo = createAppConfig()
    private val networkInfraModule = NetworkInfraModule(appInfo).koinModule
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            networkInfraModule
            CommonModule().koinModule
            NetworkServiceModule().koinModule
        }
    }
    private fun createAppConfig(): AppInfo = AppInfo(BuildConfig.API_KEY)
}