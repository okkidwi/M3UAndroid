@file:Suppress("UnstableApiUsage")

import com.android.build.api.dsl.ManagedVirtualDevice

plugins {
    alias(libs.plugins.com.android.test)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.androidx.baselineprofile)
}

android {
    namespace = "com.m3u.baselineprofile"
    compileSdk = 34
    defaultConfig {
        minSdk = 28
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    targetProjectPath = ":androidApp"

    flavorDimensions += listOf("channel", "codec")
    productFlavors {
        create("stableChannel") { dimension = "channel" }
        create("snapshotChannel") { dimension = "channel" }
        create("richCodec") { dimension = "codec" }
        create("liteCodec") { dimension = "codec" }
    }

    // This code creates the gradle managed device used to generate baseline profiles.
    // To use GMD please invoke generation through the command line:
    // ./gradlew :androidApp:generateBaselineProfile
    testOptions.managedDevices.devices {
        create<ManagedVirtualDevice>("pixel6Api34") {
            device = "Pixel 6"
            apiLevel = 34
            systemImageSource = "aosp"
        }
    }
}

// This is the configuration block for the Baseline Profile plugin.
// You can specify to run the generators on a managed devices or connected devices.
baselineProfile {
    managedDevices += "pixel6Api34"
    useConnectedDevices = false
}

dependencies {
    implementation(libs.androidx.test.ext.junit)
    implementation(libs.androidx.test.espresso.espresso.core)
    implementation(libs.androidx.test.uiautomator.uiautomator)
    implementation(libs.androidx.benchmark.benchmark.macro.junit4)
}
