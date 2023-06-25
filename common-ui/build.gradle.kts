
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.moviefy_clean_architecture.common.ui"
    compileSdk = 33
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.androidCoreKtx)
    implementation(Dependencies.androidKotlinStdLib)
    implementation(Dependencies.retrofit)
    implementation(project(mapOf("path" to ":interactor")))
}
