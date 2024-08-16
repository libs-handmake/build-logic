package util.android

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import util.Settings

fun ApplicationExtension.defaultConfig(project: Project) {
    compileSdk = Settings.TARGET_SDK
    defaultConfig {
        minSdk = Settings.MIN_SDK
        targetSdk = Settings.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Settings.javaCompatibility
        targetCompatibility = Settings.javaCompatibility
    }
    project.tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(Settings.jvmTarget)
            freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}