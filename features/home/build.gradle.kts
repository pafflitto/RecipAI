plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.features.home"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
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
    implementation(project(":libraries:core"))
    implementation(project(":libraries:ui"))
    implementation(AndroidX.lifecycleViewModel)
    testImplementation(AndroidX.junit)
    androidTestImplementation(AndroidX.junitTest)
    implementation(Kotlin.kotlinTime)

    // Hilt
    implementation(Hilt.hilt)
    implementation(Hilt.navigation_compose)
    kapt(Hilt.compiler)

    // Jetpack Compose
    val composeBom = platform(JetpackCompose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(JetpackCompose.viewModel)
    implementation(JetpackCompose.animation)
    implementation(JetpackCompose.material)
    implementation(JetpackCompose.materialCore)
    implementation(JetpackCompose.iconsCore)
    implementation(JetpackCompose.iconsExtended)
    implementation(JetpackCompose.runtime)
    implementation(JetpackCompose.ui)
    implementation(JetpackCompose.uiPreview)
    debugImplementation(JetpackCompose.uiTooling)
}

kapt {
    correctErrorTypes = true
}
