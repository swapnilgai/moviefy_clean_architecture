enum class ServerEnvironment(
    val serverName: String,
    val baseUrl: String,
    val headers: Map<String, String> = emptyMap()
) {
    DEVELOPMENT(
        serverName = "Dev",
        baseUrl = "",
        headers = emptyMap()
    )
}