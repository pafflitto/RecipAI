import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.libraries.core"
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

    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }

    defaultConfig {
        val apikeyPropertiesFile = rootProject.file("apikey.properties")
        val apikeyProperties = Properties()
        apikeyProperties.load(FileInputStream(apikeyPropertiesFile))
        buildConfigField("String", "PALM_API_KEY", apikeyProperties.getProperty("PALM_API_KEY"))
    }
}

dependencies {
    implementation(AndroidX.coreKtx)
    implementation(Kotlin.kotlinTime)
    implementation(Kotlin.serializationJson)
    testImplementation(AndroidX.junit)
    androidTestImplementation(AndroidX.junitTest)
    androidTestImplementation(AndroidX.espresso)

    // Room
    implementation(AndroidX.roomRuntime)
    annotationProcessor(AndroidX.roomCompiler)
    kapt(AndroidX.roomCompiler)
    implementation(AndroidX.roomKtx)

    // Jetpack Compose
    val composeBom = platform(JetpackCompose.bom)
    implementation(composeBom)
    implementation(JetpackCompose.runtime)

    implementation(GoogleCloud.generativeLanguage)
    implementation(OkHttp.okhttp)

    implementation(Hilt.hilt)
    kapt(Hilt.compiler)
}
