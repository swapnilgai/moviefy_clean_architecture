
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.moviefy_clean_architecture.location"
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
    implementation(dependencies.project(":common"))
    implementation(dependencies.project(":interactor"))
    implementation(dependencies.project(":common-ui"))
    implementation(dependencies.project(":network-service-module"))
    implementation(dependencies.project(":network-infra-module"))
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.androidCoreKtx)
    implementation(Dependencies.androidKotlinStdLib)
    implementation(Dependencies.servicesLocation)
    implementation(Dependencies.servicesMaps)
    implementation(Dependencies.permissions)
}
