plugins {
    id("configs")
    id("com.android.library")
}

android {
    namespace = "com.example.moviefy_clean_architecture.network.module"
    compileSdk = 33
}

dependencies {
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitGson)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLogger)
    testImplementation(Dependencies.koinTest)
}
