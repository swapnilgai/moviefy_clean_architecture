package com.example.moviefy_clean_architecture.network.infra.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_SECONDS = 30L

class ServiceFactory internal constructor( private val addHeaderInterceptor: AddHeaderInterceptor ) {
    inline fun <reified ServiceT> create(
        baseUrl: String
    ) : ServiceT  = createRetrofit(baseUrl, GsonBuilder().create()).create(ServiceT::class.java)


    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(addHeaderInterceptor)
            .build()
    }

    @PublishedApi
    internal fun createRetrofit(baseUrl: String, gson: Gson): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl.toHttpUrl())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}