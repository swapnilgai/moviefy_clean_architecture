package com.example.moviefy_clean_architecture.common.di

import com.example.moviefy_clean_architecture.common.AppRestarter
import com.example.moviefy_clean_architecture.common.AppRestarterImpl
import com.example.moviefy_clean_architecture.common.ServerEnvironment
import org.koin.dsl.module

class CommonModule(){
    val koinModule = module {
        factory<AppRestarter> { AppRestarterImpl(get()) }
        factory<ServerEnvironment> { ServerEnvironment.DEVELOPMENT }
    }
}