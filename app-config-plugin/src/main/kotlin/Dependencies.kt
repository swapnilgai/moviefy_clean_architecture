import Version.koinVersion

object Dependencies {
    const val androidXCore = "androidx.core:core-ktx:${Version.androidXCore}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val junit = "junit:junit:${Version.junit}"
    const val junitTestExt = "androidx.test.ext:junit:${Version.junitTestExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val koinAndroid = "io.insert-koin:koin-android:${Version.koinVersion}"
    const val koinTest = "io.insert-koin:koin-android-test:${Version.koinVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
}