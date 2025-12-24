android {
    namespace = "com.artistic.widget"
    compileSdk = 33 // Target Android 13

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
