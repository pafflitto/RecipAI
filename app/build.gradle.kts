plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.recipai"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.example.recipai"
        minSdk = Config.minSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

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

    packaging {
        resources.excludes.add("META-INF/INDEX.LIST")
        resources.excludes.add("META-INF/DEPENDENCIES")
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(":features:home"))
    implementation(project(":features:favorites"))
    implementation(project(":features:settings"))
    implementation(project(":libraries:ui"))

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.lifecycleRuntime)
    implementation(AndroidX.material)
    testImplementation(AndroidX.junit)
    androidTestImplementation(AndroidX.junitTest)
    androidTestImplementation(AndroidX.espresso)

    // Jetpack Compose
    val composeBom = platform(JetpackCompose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(JetpackCompose.activity)
    implementation(JetpackCompose.navigation)
    implementation(JetpackCompose.animation)
    implementation(JetpackCompose.material)
    implementation(JetpackCompose.iconsCore)
    implementation(JetpackCompose.runtime)
    implementation(JetpackCompose.ui)
    implementation(JetpackCompose.uiPreview)
    debugImplementation(JetpackCompose.uiTooling)

    implementation(Hilt.hilt)
    kapt(Hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
