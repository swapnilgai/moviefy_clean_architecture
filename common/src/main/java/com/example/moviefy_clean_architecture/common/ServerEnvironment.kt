package com.example.moviefy_clean_architecture.common

enum class ServerEnvironment(
    val serverName: String,
    val baseUrl: String,
    val headers: Map<String, String> = emptyMap()
) {
    DEVELOPMENT(
        serverName = "Dev",
        baseUrl = "https://api.themoviedb.org/3/"
    ),
    PRODUCTION(
        serverName = "Prod",
        baseUrl = "https://api.themoviedb.org/3/"
    )
}