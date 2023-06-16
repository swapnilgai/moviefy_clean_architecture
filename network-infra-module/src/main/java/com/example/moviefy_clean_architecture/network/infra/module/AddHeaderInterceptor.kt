package com.example.moviefy_clean_architecture.network.infra.module

import com.example.moviefy_clean_architecture.common.AppInfo
import okhttp3.Interceptor
import okhttp3.Response

internal class AddHeaderInterceptor(private val appInfo: AppInfo) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       val request =  chain.request().let { request ->
            request
                .newBuilder()
                .url(request.url)
                .header("Authorization:", appInfo.apiKey)
                .header("accept: ", "application/json")
                .build()
        }
       return chain.proceed(request)
    }
}