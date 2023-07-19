apply(from = "gradle/ktlint.gradle.kts")

plugins {
    id("configs")
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.6.0" apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.6.0"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
