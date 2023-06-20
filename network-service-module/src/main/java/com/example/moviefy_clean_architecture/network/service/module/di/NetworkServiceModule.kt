package com.example.moviefy_clean_architecture.network.service.module.di

import com.example.moviefy_clean_architecture.common.ServerEnvironment
import com.example.moviefy_clean_architecture.network.infra.module.ServiceFactory
import com.example.moviefy_clean_architecture.network.service.module.GetMoviesService
import org.koin.dsl.module

class NetworkServiceModule(){
   val koinModule = module {
      single {
         get<ServiceFactory>().create<GetMoviesService>(get<ServerEnvironment>().baseUrl)
      }
   }
}
