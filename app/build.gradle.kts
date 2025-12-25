plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.artistic.widget"
    compileSdk = 33 // Native Android 13 Support [cite: 2025-12-25]

    defaultConfig {
        applicationId = "com.artistic.widget"
        minSdk = 26
        targetSdk = 33 // Target API 33 [cite: 2025-12-25]
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true // Enables the Advanced UI Engine [cite: 2025-12-25]
    }
    
    // Aligns Java and Kotlin to Version 17 to prevent build crashes [cite: 2025-12-25]
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
}
