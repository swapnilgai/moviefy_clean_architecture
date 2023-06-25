package com.example.moviefy_clean_architecture.di

import android.content.Context
import android.content.res.Resources
import org.koin.dsl.module

class MainModule(context: Context){
    val koinModule = module {
        single<Resources> { context.resources }
    }
}