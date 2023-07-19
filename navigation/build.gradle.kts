plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.moviefy_clean_architecture.navigation"
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
    implementation(Dependencies.Navigation.navigationUi)
}
