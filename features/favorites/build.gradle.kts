plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.features.favorites"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
}

dependencies {
    testImplementation(AndroidX.junit)
    androidTestImplementation(AndroidX.junitTest)

    // Jetpack Compose
    val composeBom = platform(JetpackCompose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(JetpackCompose.animation)
    implementation(JetpackCompose.material)
    implementation(JetpackCompose.iconsCore)
    implementation(JetpackCompose.runtime)
    implementation(JetpackCompose.ui)
    implementation(JetpackCompose.uiPreview)
    debugImplementation(JetpackCompose.uiTooling)
}
