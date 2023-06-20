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
    plugins.register("configs") {
        id = "configs"
        implementationClass = "com.example.moviefy_clean_architecture.BuildPlugin"
    }
}
