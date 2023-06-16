package com.example.moviefy_clean_architecture.network.infra.module.di

import com.example.moviefy_clean_architecture.common.AppInfo
import com.example.moviefy_clean_architecture.network.infra.module.AddHeaderInterceptor
import com.example.moviefy_clean_architecture.network.infra.module.ServiceFactory
import org.koin.dsl.module

class NetworkInfraModule(val appInfo: AppInfo) {
    val koinModule = module {
        single {
            AddHeaderInterceptor(appInfo)
        }
        single {
            ServiceFactory(get())
        }
    }
}