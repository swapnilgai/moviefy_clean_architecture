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
        sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(Dependencies.appcompat)
    implementation(Dependencies.material)
    implementation(Dependencies.androidXCore)
    implementation(Dependencies.koinAndroid)
    implementation(dependencies.project(":common"))
    implementation(dependencies.project(":network-infra-module"))
    implementation(dependencies.project(":network-service-module"))
    androidTestImplementation(Dependencies.espresso)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.junitTestExt)
    // testImplementation(Dependencies.koinTest)
}
