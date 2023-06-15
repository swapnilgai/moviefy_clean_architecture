import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins.register("app-config") {
        id = "app-config"
        implementationClass = "com.example.moviefy_clean_architecture.BuildPlugin"
    }
}
