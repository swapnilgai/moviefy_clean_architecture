import com.example.moviefy_clean_architecture.projectProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("configs")
}
val projectProperties: ProjectProperties = projectProperties().get()

android {
    namespace = "com.example.moviefy_clean_architecture"
    compileSdk = 33
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        buildConfigField("String", "API_KEY", "\"${projectProperties.apiKey}\"")
        applicationId = "com.example.moviefy_clean_architecture"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.androidXCore)
    implementation(Dependencies.koinAndroid)
    implementation(dependencies.project(":common"))
    implementation(dependencies.project(":network-service-module"))
    implementation(dependencies.project(":network-infra-module"))
    implementation(Dependencies.androidCoreKtx)
    androidTestImplementation(Dependencies.espresso)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.junitTestExt)
}
