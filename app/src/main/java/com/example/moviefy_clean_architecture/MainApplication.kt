package com.example.moviefy_clean_architecture

import android.app.Application
import com.example.moviefy_clean_architecture.common.AppInfo
import com.example.moviefy_clean_architecture.network.infra.module.di.NetworkInfraModule
import org.koin.core.context.startKoin

class MainApplication : Application() {

    val appInfo = createAppConfig()
    val networkInfraModule = NetworkInfraModule(appInfo).koinModule
    override fun onCreate() {
        super.onCreate()
        startKoin {
            networkInfraModule
        }
    }
    fun createAppConfig(): AppInfo = AppInfo(BuildConfig.API_KEY)
}