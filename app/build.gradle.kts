plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.artistic.widget"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.artistic.widget"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures { compose = true }
    composeOptions { kotlinCompilerExtensionVersion = "1.4.3" }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.glance:glance-appwidget:1.0.0-beta01")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}